package Topic100

import (
	"AlgorithmPractice/src/Common/MidwareConn/HTTPConn"
	"fmt"
	"sync"
	"testing"
	"time"
)

// A_Practice01
// @author: 蔚蔚樱
// @date: 2022/5/2319:00
// @author—Email: micromicrohard@outlook.com
// @description:
// @blogURL:

func TestYY(t *testing.T) {
	AddPickUpDistance()
	time.Sleep(8 * time.Second)
}

func Dowork(i int) map[int]string {
	DoworkBeginTime := time.Now().UnixNano()
	time.Sleep(5000 * time.Nanosecond)
	fmt.Println("Dowork last time:", i, "----", time.Now().UnixNano()-DoworkBeginTime)
	jjMap := make(map[int]string)
	jjMap[i] = fmt.Sprintf("%d_Dowork", i)
	return jjMap
}

func AddPickUpDistance() {
	httpcli := HTTPConn.RestHttpCli{}
	wg := sync.WaitGroup{}

	geoBeginTime := time.Now().UnixNano()

	for i := 0; i < 5; i++ {
		wg.Add(1)

		go func(count int) {

			defer wg.Done()
			beginTime := time.Now().UnixNano()
			defer func(beginTime1 int64) {
				fmt.Println("signle Dowork last time)))))))))):", count, "----", time.Now().UnixNano()-beginTime1)
			}(beginTime)

			httpcli.HttpGet("https://www.hao123.com")
			fmt.Println("signle Dowork last time:", count, "----", time.Now().UnixNano()-beginTime)
		}(i)
	}
	fmt.Println("Dowork last time total_wait_before:", time.Now().UnixNano()-geoBeginTime)
	wg.Wait()
	fmt.Println("Dowork last time total_wait_end:", time.Now().UnixNano()-geoBeginTime)

}

type People struct {
	Name string
}

func (p *People) String() string {
	return fmt.Sprintf("print: %v", p)
}

func TestAAA(t *testing.T) {
	p := &People{}
	p.String()
}
