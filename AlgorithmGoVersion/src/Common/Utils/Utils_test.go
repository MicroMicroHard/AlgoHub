package Utils

import (
	C "AlgorithmPractice/src/Common/Constant"
	"AlgorithmPractice/src/Common/MidwareConn/DBConn"
	"fmt"
	"github.com/stretchr/testify/assert"
	"testing"
	"time"
)

// CommUtils_test
// @author: 蔚蔚樱
// @date: 2022/5/822:53
// @author—Email: micromicrohard@outlook.com
// @description:
// @blogURL:

func TestPlaceHolder(t *testing.T) {
	var (
		strTools = &StringTools{}
	)
	assertions := assert.New(t)
	sourceMap := map[string]interface{}{
		"ss":   "ee",
		"name": "张三",
		"age":  999,
		"addr": "上海市xx区",
	}

	sourceStr := "{\"A\":\"alpah\",\"name\":\"我的姓名是#name#\",\"info\":\"我的年均是#age#，我的家庭住址是#addr#\"}"
	answerStr, err := strTools.MapPlaceHolder(sourceStr, sourceMap)
	targetStr := "{\"A\":\"alpah\",\"info\":\"我的年均是999，我的家庭住址是上海市xx区\",\"name\":\"我的姓名是张三\"}"
	assertions.Equal(err, nil)
	assertions.Equal(answerStr, targetStr)

	sourceStr = "{\"A\":\"alpah\",\"name\":\"我的姓名是#name#\",\"info\":\"我的年均是#age#，#我的家庭住址是#addr#\"}"
	answerStr, err = strTools.MapPlaceHolder(sourceStr, sourceMap)
	targetStr = "{\"A\":\"alpah\",\"info\":\"我的年均是#age#，#我的家庭住址是#addr#\",\"name\":\"我的姓名是张三\"}"
	assertions.Equal(err, nil)
	assertions.Equal(answerStr, targetStr)

	sourceStr = ""
	answerStr, err = strTools.MapPlaceHolder(sourceStr, sourceMap)
	targetStr = ""
	assertions.Equal(err.Error(), "unexpected end of JSON input")
	assertions.Equal(answerStr, targetStr)

	sourceStr = "{\"A\":\"#alpah#\",\"name\":\"我的姓名是#name#\",\"info\":\"我的年均是#age#，我的家庭住址是#addr#\"}"
	answerStr, err = strTools.MapPlaceHolder(sourceStr, sourceMap)
	targetStr = "{\"A\":\"\",\"info\":\"我的年均是999，我的家庭住址是上海市xx区\",\"name\":\"我的姓名是张三\"}"
	assertions.Equal(err, nil)
	assertions.Equal(answerStr, targetStr)

	sourceStr = "{\"A\":\"alpah\",\"name\":\"我的姓名是#name#\",\"info\":\"我的年均是#age#，我的家庭住址是#addr#\",\"\"}"
	answerStr, err = strTools.MapPlaceHolder(sourceStr, sourceMap)
	targetStr = ""
	assertions.Equal(err.Error(), "invalid character '}' after object key")
	assertions.Equal(answerStr, targetStr)

	sourceMap = map[string]interface{}{}
	sourceStr = "{\"A\":\"#alpah#\",\"name\":\"我的姓名是#name#\",\"info\":\"我的年均是#age#，我的家庭住址是#addr#\"}"
	answerStr, err = strTools.MapPlaceHolder(sourceStr, sourceMap)
	targetStr = "{\"A\":\"\",\"info\":\"我的年均是，我的家庭住址是\",\"name\":\"我的姓名是\"}"
	assertions.Equal(err, nil)
	assertions.Equal(answerStr, targetStr)
}

func TestTimeUnix(t *testing.T) {
	TimeUnix()
}

// 时间戳： http://www.45fan.com/article.php?aid=1D2LBfFlEH3ifUx9#_label3_0_1_0
func TestTimeStamp(t *testing.T) {
	timeTools := TimeTools{}
	/*	currentTime := time.Now()
		nanoTime := currentTime.UnixNano() / 1e6
		timeStr := time.Unix(nanoTime/1e3, 0)
		fmt.Println("当前")
		fmt.Println("时间戳[毫秒]:", nanoTime, "时间:", timeStr)*/
	currentTime := time.Now()
	// Valid time units are "ns", "us" (or "µs"), "ms", "s", "m", "h".
	params := [...]string{"0s", "-0s", "-1H", "-4.1s", "4s", "4.1s", "-48h", "-1m30s", "-1h"} // attention: -1H:大写的H不生效
	for _, param := range params {
		fmt.Printf("%s前", param)
		timeTools.TimeStampGap(currentTime, param)
	}
}

func TestTimeSinceUnix(t *testing.T) {
	start := time.Now()
	time.Sleep(2 * time.Second)
	scoreCost := time.Since(start)

	fmt.Println(time.Since(start).String()) // attention: String这个方法会根据时间变化，出现 s/ms/ns
	fmt.Println("scoreCost:", scoreCost)
	fmt.Println("scoreCost.Seconds() * 1000:", scoreCost.Seconds()*1000)
	fmt.Println("scoreCost.Milliseconds():", scoreCost.Milliseconds())
}

func TestSet1(t *testing.T) {
	begin := time.Now().UnixNano()
	count := 10
	for i := 0; i < count; i++ {
		fmt.Println("-------")
		time.Sleep(1000 * time.Nanosecond) // time attention:此处实际不止 1 * time.Microsecond， 因为cpu调度的最小周期是 10 ms,所以sleep的时间最小是10 ms
	}
	end := time.Now().UnixNano() - begin
	fmt.Println("end:", end/1000, "ms,----pre/10:", end/(int64(count)*1000))
}

func TestGetMax(t *testing.T) {
	assertions := assert.New(t)
	assertions.Equal(GetMax(23, 12), 23)
	assertions.Equal(GetMax(123, 12), 123)
	assertions.Equal(GetMax(-23, 12), 12)
	assertions.Equal(GetMax(66, 77), 77)
	assertions.Equal(GetMax(C.Max, C.Min), C.Max)
	assertions.Equal(GetMax(C.Max, C.Max), C.Max)
	assertions.Equal(GetMax(C.Min, C.Min), C.Min)
	assertions.Equal(GetMax(-23, -12), -12)
}

func TestGetMin(t *testing.T) {
	assertions := assert.New(t)
	assertions.Equal(GetMin(23, 12), 12)
	assertions.Equal(GetMin(123, 12), 12)
	assertions.Equal(GetMin(-23, 12), -23)
	assertions.Equal(GetMin(66, 77), 66)
	assertions.Equal(GetMin(C.Max, C.Min), C.Min)
	assertions.Equal(GetMin(C.Max, C.Max), C.Max)
	assertions.Equal(GetMin(C.Min, C.Min), C.Min)
	assertions.Equal(GetMin(-23, -12), -23)
}

func TestGetArrayMaxIndex(t *testing.T) {

	assertions := assert.New(t)
	array := []int{-22, -11, 0, 11, 22, 33, 44}

	assertions.Equal(GetArrayMaxIndex(array, 23, 12), C.ErrorNum)
	assertions.Equal(GetArrayMaxIndex(array, 0, 1), 1)
	assertions.Equal(GetArrayMaxIndex(array, 1, 2), 2)
	assertions.Equal(GetArrayMaxIndex(array, 2, 3), 3)
	assertions.Equal(GetArrayMaxIndex(array, 3, 4), 4)
	assertions.Equal(GetArrayMaxIndex(array, 4, 5), 5)
	assertions.Equal(GetArrayMaxIndex(array, 5, 6), 6)
}

func TestGetArrayMinIndex(t *testing.T) {

	assertions := assert.New(t)
	array := []int{-22, -11, 0, 11, 22, 33, 44}

	assertions.Equal(GetArrayMinIndex(array, 23, 12), C.ErrorNum)
	assertions.Equal(GetArrayMinIndex(array, 0, 1), 0)
	assertions.Equal(GetArrayMinIndex(array, 1, 2), 1)
	assertions.Equal(GetArrayMinIndex(array, 2, 3), 2)
	assertions.Equal(GetArrayMinIndex(array, 3, 4), 3)
	assertions.Equal(GetArrayMinIndex(array, 4, 5), 4)
	assertions.Equal(GetArrayMinIndex(array, 5, 6), 5)
}

func TestGetArrayMinIndex1(t *testing.T) {
	scene := make(map[string]int)
	scene["route"] = 66
	scene["brazil"] = 4
	scene["china"] = 960
	for k, v := range scene {
		fmt.Println(k, v)
	}
}

func TestGetSqlResult(t *testing.T) {
	tools := DBConnTools{}
	result, err := tools.UTDate_QueryBySlaver("FindNum_Treble_One", true)
	if err != nil {
		fmt.Println(err)
	}
	for _, v := range result {
		v.Print()
	}
}

func TestInsertUTData(t *testing.T) {
	tools := DBConnTools{}

	input_ := "1111"
	output_ := "1111"
	className_ := "1111"
	entity := &DBConn.UTDataEntity{
		Input:     &input_,
		Output:    &output_,
		ClassName: &className_,
	}
	tools.InsertUTData(entity)
}
