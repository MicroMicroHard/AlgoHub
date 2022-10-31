package study

import (
	"AlgorithmPractice/src/Common/golangGrammar/timeout_control"
	"context"
	"encoding/json"
	"fmt"
	"sync"
	"testing"
	"time"
)

/**
 * @author 蔚蔚樱
 * @version V1.0
 * @date 2022/10/21 00:39
 * @author-Email micromicrohard@outlook.com
 * @description
 * 1、并发读写map导致panic：fatal error: concurrent map iteration and map write
 * 2、并发读写map导致panic：使用sync.Mutex 加锁，可以避免 并发Panic
 * 3、并发读写map导致panic：一边往map里面写数据，一边进行序列化
 * 4、由于超时后子协程仍在继续写map,导致序列化失败，产生Panic，加上注释部分，可以解决这个问题
 */

// 并发读写map导致panic：fatal error: concurrent map iteration and map write
func Test_ConcurrencyWriteRead_WithLock_Cover_Map_Panic(t *testing.T) {
	mmMap := make(map[string]string)
	go WriteMap(mmMap)
	go ReadMap(mmMap)
	time.Sleep(3 * time.Second)
}

// 并发读写map导致panic：使用sync.Mutex 加锁，可以避免 并发Panic
func Test_ConcurrencyWriteRead_Cause_Map_Panic(t *testing.T) {
	mmMap := make(map[string]string)
	//var tempMutex sync.Mutex // grammar sync.Mutex 的 初始化 和引用方式
	tempMutex := &sync.Mutex{}
	go WriteMapWithLock(mmMap, tempMutex)
	go ReadMapWithLock(mmMap, tempMutex)
	time.Sleep(3 * time.Second)
}

// 并发读写map导致panic：一边往map里面写数据，一边进行序列化
func Test_Concurrency_Panic(t *testing.T) {
	minMap := make(map[string]string)
	t1 := struct {
		mMap map[string]string
	}{
		minMap,
	}
	go WriteMap(t1.mMap)
	_, err := json.Marshal(minMap)
	if err != nil {
		fmt.Println("err:", err)
		return
	}
	time.Sleep(3 * time.Second)
}

// 由于超时后子协程仍在继续写map,导致序列化失败，产生Panic
func Test_TimeOut_Cause_Map_Panic(t *testing.T) {
	minMap := make(map[string]string)
	t1 := struct {
		mMap map[string]string
	}{
		minMap,
	}
	ctx := context.Background()
	err := timeout_control.ExecuteWithTimeout(ctx, 2, func(ctx context.Context) error {
		for i := 0; i < 10000; i++ {
			if i%100 == 0 {
				fmt.Println("1:", i)
			}
			//除了加锁，还可以控制Deadline，保证超时后子协程不在继续工作，加上注释部分，可以解决这个问题
			/*if tt, _ := ctx.Deadline(); time.Since(tt) > 0 {
				return nil
			}*/
			key := fmt.Sprintf("key+%d", i)
			t1.mMap[key] = fmt.Sprintf("value+%d", i)
		}
		return nil
	})
	if err != nil {
		fmt.Println("timeout err:", err)
	}
	fmt.Println("--------------------")
	/*1、timeout之后，依旧有协程在往map里面写数据
	2、Marshal对map有读的操作，并发读写map导致 fatal error: concurrent map iteration and map write*/
	_, err = json.Marshal(minMap)
	if err != nil {
		fmt.Println("err:", err)
		return
	}
	time.Sleep(3 * time.Second)
}

func WriteMap(mMap map[string]string) {
	for i := 0; i < 10000; i++ {
		if i%100 == 0 {
			fmt.Println("1:", i)
		}
		key := fmt.Sprintf("key+%d", i)
		mMap[key] = fmt.Sprintf("value+%d", i)
	}
}

func ReadMap(mMap map[string]string) {
	for i := 0; i < 10000; i++ {
		if len(mMap) > 0 {
			fmt.Println()
			for k, v := range mMap {
				fmt.Println("k:", k, "-------v:", v)
			}
		}
		fmt.Printf("empty")
	}
}

func WriteMapWithLock(mMap map[string]string, tempMutex *sync.Mutex) {
	if tempMutex == nil {
		fmt.Println("tempMutex == nil")
	}
	tempMutex.Lock()
	defer tempMutex.Unlock()
	for i := 0; i < 1000; i++ {
		key := fmt.Sprintf("key+%d", i)
		mMap[key] = fmt.Sprintf("value+%d", i)
	}
}

func ReadMapWithLock(mMap map[string]string, tempMutex *sync.Mutex) {
	if tempMutex == nil {
		fmt.Println("000000020000")
	}
	for i := 0; i < 10000; i++ {
		if len(mMap) > 0 {
			fmt.Println("len:", len(mMap))
			break
		}
		fmt.Printf("empty")
	}
	fmt.Println()
	if tempMutex == nil {
		fmt.Println("00000000000")
	}
	tempMutex.Lock()
	defer tempMutex.Unlock()
	for k, v := range mMap {
		fmt.Println("k:", k, "-------v:", v)
	}
}
