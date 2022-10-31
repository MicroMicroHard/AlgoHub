package concurrency2array_effect

import (
	"fmt"
	"sync"
	"testing"
	"time"
)

type YYYY struct {
	WaybillId *uint64
	DriverId  *uint64
	ScoreMap  map[string]float64
}

func TestAA(t *testing.T) {
	wg := sync.WaitGroup{}
	arr := make([]map[string]*YYYY, 1000, 1000)
	for i := 0; i < 1000; i++ {
		wg.Add(1)
		go func(index int) {
			defer wg.Done()
			ans := make(map[string]*YYYY)

			dg := fmt.Sprintf("_%d", index)
			ff := make(map[string]float64)
			ff["dg"] = float64(index)
			u := uint64(index)
			ans[dg] = &YYYY{
				WaybillId: &u,
				DriverId:  &u,
				ScoreMap:  ff,
			}
			arr[index] = ans
		}(i)
	}
	wg.Wait()

	time.Sleep(3 * time.Second)

	for i, _ := range arr {
		if *arr[i][fmt.Sprintf("_%d", i)].WaybillId != uint64(i) {
			fmt.Println(arr[i])
		}
		if i%50 == 0 {
			fmt.Println(arr[i][fmt.Sprintf("_%d", i)].ScoreMap["dg"])
		}
	}
}

func TestAA1(t *testing.T) {
	arr := make([]int, 100, 100)

	for i := 0; i < 100; i++ {
		arr[i] = i
	}
	time.Sleep(3 * time.Second)
	for i, _ := range arr {
		fmt.Println(arr[i])
	}
}

func TestAAA(t *testing.T) {
	wg := sync.WaitGroup{}
	arr := make(map[string]*YYYY)

	for i := 0; i < 1000; i++ {
		wg.Add(1)
		go func(index int) {
			defer wg.Done()
			dg := fmt.Sprintf("_%d", index)
			ff := make(map[string]float64)
			ff["dg"] = float64(index)
			u := uint64(index)
			arr[dg] = &YYYY{
				WaybillId: &u,
				DriverId:  &u,
				ScoreMap:  ff,
			}
		}(i)
	}
	wg.Wait()

	time.Sleep(2 * time.Second)
	fmt.Println(len(arr))
}
