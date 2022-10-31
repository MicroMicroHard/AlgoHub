package timeout_control

import (
	"context"
	"fmt"
	"github.com/pkg/errors"
	"time"
)

// TimeOutControl
// @author: 蔚蔚樱
// @date: 2022/9/215:20
// @author—Email: micromicrohard@outlook.com
// @description: 超时控制
// @blogURL:
type TimeOutControl struct {
}

func ExecuteWithTimeout(parent context.Context, timeoutMs int, fn func(context.Context) error) (err error) {

	ctx, cancel := context.WithTimeout(parent, time.Duration(timeoutMs)*time.Millisecond)
	defer cancel()
	done := make(chan bool, 1)

	go func() {
		defer func() {
			if e := recover(); e != nil {
				err = errors.Errorf("execute error: %v", e)
			}
			done <- true
		}()
		err = fn(ctx)
	}()

	select {
	case <-ctx.Done():
		err = errors.New("execute timeout")
	case <-done:

	}
	return
}

func ExecuteSubTaskWithTimeout(parent context.Context, cancel context.CancelFunc, fn func(context.Context) error) (err error) {

	defer func() {
		fmt.Println("cancel--------1")
		cancel()
		fmt.Println("cancel--------2")
	}()
	done := make(chan bool, 1)

	go func() {
		defer func() {
			if e := recover(); e != nil {
				err = errors.Errorf("execute error: %v", e)
			}
			done <- true
		}()
		err = fn(parent)
	}()

	select {
	case <-parent.Done():
		fmt.Println("parent.Done()")
		err = errors.New("execute timeout")
	case <-done:
		fmt.Println("done")
	}
	return
}
