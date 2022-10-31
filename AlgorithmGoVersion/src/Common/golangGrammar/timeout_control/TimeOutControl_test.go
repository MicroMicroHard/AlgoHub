package timeout_control

import (
	"AlgorithmPractice/src/Common/ThreadPool"
	"context"
	"errors"
	"fmt"
	"sync"
	"testing"
	"time"
)

func TestExecuteWithTimeout(t *testing.T) {
	ctx := context.Background()
	err := ExecuteWithTimeout(ctx, 2000, PrintNum)
	if err != nil {
		fmt.Println("timeout err:", err)
	}
	time.Sleep(6 * time.Second)
}

func PrintNum(ctx context.Context) error {
	for i := 0; i < 10000; i++ {
		fmt.Println(i)
		time.Sleep(200 * time.Millisecond)
		// timeout grammar : 超时后不在继续执行
		if tt, _ := ctx.Deadline(); time.Since(tt) > 0 {
			fmt.Println(time.Since(tt))
			return nil
		}
	}
	return nil
}

func Test_Cancel(t *testing.T) {
	ctx := context.Background()
	ctxWithTimeout, cancel := context.WithTimeout(ctx, time.Duration(300)*time.Millisecond)

	t1, _ := ctxWithTimeout.Deadline()
	fmt.Println("111111", time.Since(t1))

	AA(ctxWithTimeout)

	cancel()
	t1, _ = ctxWithTimeout.Deadline()
	fmt.Println("222222", time.Since(t1))
}

func AA(ctx context.Context) {
	deadlineTime, _ := ctx.Deadline()
	fmt.Println(time.Since(deadlineTime))

	time.Sleep(1500 * time.Millisecond)

	deadlineTime, _ = ctx.Deadline()
	fmt.Println("------", time.Since(deadlineTime))
}

func TestExecuteWithTimeout1(t *testing.T) {
	ctx := context.Background()
	ctx, cancel := context.WithCancel(ctx)

	go func() {
		YY1(ctx)
	}()

	err := YY2(ctx)
	fmt.Println(err)
	if err != nil {
		cancel()
	}
}

func YY1(ctx context.Context) {
	select {
	case <-time.After(500 * time.Millisecond):
		fmt.Println("111111111")
	case <-ctx.Done():
		fmt.Println("22222222")
	}
}

func YY2(ctx context.Context) error {
	time.Sleep(100 * time.Millisecond)
	return errors.New("new error ")
}

func TestExecuteSubTaskWithTimeout(t *testing.T) {
	ctx := context.Background()

	ctx_, cancel := context.WithTimeout(ctx, time.Duration(300)*time.Millisecond)
	err := ExecuteSubTaskWithTimeout(ctx_, cancel, func(context.Context) error {
		TimeoutTaskPool(ctx_)
		return nil
	})
	if err != nil {
		fmt.Println("总任务异常结束：A----AA------A")
		fmt.Println(err)
	} else {
		fmt.Println("总任务正常结束：A----AA------A")
	}
	a, _ := ctx_.Deadline()
	fmt.Println("总体控时", time.Since(a))
}

var (
	ScoreRPCTaskPool = ThreadPool.NewPool(3)
)

func TimeoutTaskPool(ctx context.Context) {
	wg := sync.WaitGroup{}
	for i := 0; i < 100; i++ {
		v := i
		fmt.Println("开启的任务：------", i)
		t := func() error { // 单次RPC超时后不再请求
			if deadlineTime, _ := ctx.Deadline(); time.Since(deadlineTime) > 0 {
				fmt.Println("任务在协程池，但是来不及执行：------")
				return nil
			}
			return PrintNum1(ctx, v)
		}
		taskFunc := ThreadPool.TaskStruct{
			Fun:          t,
			TheWaitGroup: &wg,
		}
		_ = ScoreRPCTaskPool.Put(taskFunc)
	}
}

func PrintNum1(ctx context.Context, value int) error {
	fmt.Println("开始执行子任务：sub task:", value)
	time.Sleep(100 * time.Millisecond)
	// timeout grammar : 超时后不在继续执行
	fmt.Println("-----", "执行子任务记录：sub task:", value, "-----")
	tt, _ := ctx.Deadline()
	fmt.Println("结束执行子任务：sub task:", value, "-----", time.Since(tt))
	return nil
}

func TestExecuteSubTaskWithTimeout1(t *testing.T) {

	ctx := context.Background()
	err := ExecuteWithTimeout(ctx, 2, func(ctx context.Context) error {
		_, cancel := context.WithTimeout(ctx, time.Millisecond*1)
		err := PrintNum1(ctx, 55)
		fmt.Println("GetScoreRPC", "err:", err)
		cancel()
		if err != nil {
			fmt.Println("get score rpc error_then_monitor")
		}
		return nil
	})
	if err != nil {
		fmt.Println("get score rpc error_then_monitor")
	}
}
