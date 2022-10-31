package Utils

import (
	"fmt"
	"time"
)

// TimeTools
// @author: 蔚蔚樱
// @date: 2022/6/1420:14
// @author—Email: micromicrohard@outlook.com
// @description:
// @blogURL:
type TimeTools struct {
}

func TimeUnix() {
	timeUnix := time.Now()
	fmt.Println("时间戳(秒)timeUnix[s]  ", timeUnix.Unix()) // time grammar 单位s,  打印结果:1491888244
	fmt.Printf("时间戳(纳秒转换为秒)   %v;\n", timeUnix.UnixNano()/1e9)

	fmt.Printf("时间戳(毫秒)    %v;\n", timeUnix.UnixNano()/1e6)

	//fmt.Println("timeUnixMicro[ms](微秒)", timeUnix.UnixMicro()) // time grammar 单位毫秒,打印结果：1491888244752784461

	fmt.Println("时间戳(纳秒)timeUnixNano[ns]", timeUnix.UnixNano()) // time grammar 单位纳秒,打印结果：1491888244752784461
	/*
		timeUnix[s]            1660738295
		时间戳(秒)              1660738295;
		时间戳(纳秒转换为秒)      1660738295;
		时间戳(毫秒)             1660738295594;
		timeUnixMicro[ms](微秒) 1660738295594493
		timeUnixNano[ns]       1660738295594493000
		时间戳(纳秒)             1660738295594493000;
	*/
}

// 获取params间隔之后的时间戳： http://www.45fan.com/article.php?aid=1D2LBfFlEH3ifUx9#_label3_0_1_0
// Valid time units are "ns", "us" (or "µs"), "ms", "s", "m", "h".
// 示例：TimeStampGap(当前时间,-1h) = 当前时间的前一个小时
func (t *TimeTools) TimeStampGap(currentTime time.Time, params string) time.Time {

	m, _ := time.ParseDuration(params)
	result := currentTime.Add(m)

	nanoTime := result.UnixNano() / 1e6
	timeStr := time.Unix(nanoTime/1e3, 0)
	fmt.Println(result, "时间戳[毫秒]:", nanoTime, "时间:", timeStr)
	return result
}

// 获取当天0点的时间戳
func (t *TimeTools) GetBeforeDawnTimeStamp() int64 {
	ti := time.Now()
	// attention：t.Location()表示当前地区，需要考虑其他地区的时候进行替换
	addTime := time.Date(ti.Year(), ti.Month(), ti.Day(), 0, 0, 0, 0, ti.Location())
	return addTime.Unix()
}

// 今天是周几
func (t *TimeTools) GetWeekDay() int64 {
	ti := time.Now()
	return int64(ti.Weekday())
}

//当前时间 15min 分桶 0-95
/*func GetTimeBucketByFifteenMin() (a, b int64) {
	nowTime := time.Now().Unix()
	beforeDawntime := GetBeforeDawnTimeStamp()
	a = (nowTime - beforeDawntime) / (15 * 60)
	b = (nowTime - beforeDawntime) % (15 * 60)
	if b != 0 {
		a++
	}
	return a, b
}*/
