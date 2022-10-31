package golangGrammar

import (
	"fmt"
	"github.com/thoas/go-funk"
	"sync"
	"testing"
)

func TestCheckNum_CheckNumMethod(t *testing.T) {

	var p *[26]byte
	p = getStr()
	fmt.Println(*p)
}

func getStr() *[26]byte {
	buf := [26]byte{}
	for i := 0; i < len(buf); i++ {
		buf[i] = byte(i + 'a')
	}
	return &buf
}

var df = func(u int) int {
	return u * 100
}

func UU(u int) int {
	return u * 50
}

func TestCheckNum_C1heckNumMethod(t *testing.T) {
	i := 3
	va := df(i)
	fmt.Println(va)
	vr := UU(i)
	fmt.Println(vr)
}


type Extend struct {
	Fields map[string]interface{}
	lock   *sync.Mutex
}

// thread-safe add kv
func (extend *Extend) Add(key string, val interface{}) {
	extend.lock.Lock()
	defer extend.lock.Unlock()
	if extend.Fields == nil {
		extend.Fields = make(map[string]interface{}, 32)
	}
	extend.Fields[key] = val
}

func NewExtend() Extend {
	var tempMutex sync.Mutex // grammar : 缺失这个，导致空指针问题
	return Extend{
		Fields: make(map[string]interface{}, 0),
		lock:   &tempMutex,
	}
}

func TestHeapSort1(t *testing.T) {

	var wayBillItemQuantity uint64 = 10
	var driverItemQuantity uint64 = 0
	h := uint64(20)
	if wayBillItemQuantity+driverItemQuantity > h {
		fmt.Println("------")
	} else {
		fmt.Println("+++++++")
	}

	fmt.Println(float64(0))
	sayhello("john", addperfix)
}
func addperfix(perfix, name string) {
	fmt.Println(perfix, "!", name)
}
func sayhello(name string, f func(string, string)) {
	f("hello", name)
}

func TestChunk(t *testing.T) {

	ids := []uint64{1, 2, 3, 11, 4, 5, 6, 7, 8, 9, 0}
	BatchRpcQuerySize := 5
	batchWaybillIds := (funk.Chunk(ids, BatchRpcQuerySize)).([][]uint64) // batch grammar:funk.Chunk的用法，自动按照 size 分组

	for _, id := range batchWaybillIds {
		for _, u := range id {
			fmt.Print(u, "-")
		}
	}
}

func TestHeapSort(t *testing.T) {

	//innerSortTest.SortSQLTest(t, &innerSortImpl.HeapSort{})

	ans := make(map[uint64]map[string]interface{}, 0)

	sd := make(map[string]interface{})
	sd["b_fd_order_comple_num"] = 4
	sd["b_real_szsdk_deviceid"] = "xxxxx"
	ans[1206557685] = sd

	requestData := make(map[uint64]*Extend)
	sdd := make(map[string]interface{})
	sdd["b_fd_order_comple_num"] = 4
	sdd["b_real_szsdk_deviceid"] = "xxxxx"

	ed := NewExtend()
	ed.Fields = sdd
	requestData[1206557685] = &ed

	for id, extendData := range requestData {
		if featureResponse, exist := ans[id]; exist {
			for featureName, featureValue := range featureResponse {
				//fmt.Println(extendData, featureName, featureValue)
				extendData.Add(featureName, featureValue)
			}
		}
	}

}
