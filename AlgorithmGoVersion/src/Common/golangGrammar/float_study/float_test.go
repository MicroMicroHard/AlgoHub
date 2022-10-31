package float_study

import (
	C "AlgorithmPractice/src/Common/Constant"
	"fmt"
	"github.com/shopspring/decimal"
	"strconv"
	"testing"
	"time"
)

// attention： float 的0 不可以直接比较[精度不一致]
func TestFloat_compare_0(t *testing.T) {

	if GetFloat() == 0.0 {
		fmt.Println("wrong:===0")
	} else {
		fmt.Println("wrong:not ")
	}

	if GetFloat()-1e-8 == 0.0 {
		fmt.Println(" ===0")
	} else {
		fmt.Println("not ")
	}
	fmt.Println(time.Now())
}

func GetFloat() float32 {
	return 0.0000000000000000000000000000000000000000000000000000000000001
}

// grammar float32 float64 float 精度问题
func TestFloat_compare_1(t *testing.T) {
	var threshold_32 float32 = 0.05
	var threshold_64 float64 = 0.05

	threshold_64_32 := float32(threshold_64)
	fmt.Println("64 转32：", threshold_64_32)

	threshold_32_64 := float64(threshold_32)
	fmt.Println("32 转64：", threshold_32_64)

	threshold_32_64_32 := float32(threshold_32_64)
	fmt.Println("32 转64,再重新转回来32", threshold_32_64_32)

	vv32 := decimal.NewFromFloat32(threshold_32)
	value, _ := vv32.Float64()
	fmt.Println("32 转64 (精度)：", value)
}

func TestFloat_compare_plus(t *testing.T) {
	var threshold_32 float32 = 0.05111111111111110000000000000001 // attention 32转64 小数点后7位开始错乱
	var threshold_64 float64 = 0.05111111111111110000000000000001 // attention 64转32 只会保留小数点后8位

	threshold_64_32 := float32(threshold_64)
	fmt.Println("64 转32：", threshold_64_32)

	threshold_32_64 := float64(threshold_32)
	fmt.Println("32 转64：", threshold_32_64)

	threshold_32_64_32 := float32(threshold_32_64)
	fmt.Println("32 转64,再重新转回来32", threshold_32_64_32)

	vv32 := decimal.NewFromFloat32(threshold_32)
	value, _ := vv32.Float64()
	fmt.Println("32 转64 (精度)：", value)
}

func TestFloat_compare_2(t *testing.T) {
	var threshold1 float64 = 0.05000000074505806
	threshold := float32(threshold1)
	fmt.Println(threshold)

	var threshold2 float64 = 0.05
	fmt.Println("--------")
	threshold = float32(threshold2)
	fmt.Println(threshold)

	var threshold3 float64 = 0.049999999999999999999999991
	fmt.Println("--------")
	threshold = float32(threshold3)
	fmt.Println(threshold)

	fmt.Println("+++++++++++++++")
	var threshold4 float32 = 0.05000000074505806
	threshold = FloatRound32(threshold4, 2)
	fmt.Println(threshold)

	var threshold5 float32 = 0.05
	fmt.Println("--------")
	threshold = FloatRound32(threshold5, 2)
	fmt.Println(threshold)

	var threshold6 float32 = 0.049999999999999999999999991
	fmt.Println("--------")
	threshold = FloatRound32(threshold6, 2)
	fmt.Println(threshold)
}

// FloatRound32 截取小数位数
func FloatRound32(f float32, n int) float32 {
	format := "%." + strconv.Itoa(n) + "f"
	res, _ := strconv.ParseFloat(fmt.Sprintf(format, f), 64)
	return float32(res)
}

// 精度截取
func TestFloat_compare_3(t *testing.T) {
	var ff float64
	ff = -1.355123156
	ff = FloatRound(ff, 4)
	fmt.Println(ff) // 输出 -1.3551
}

// 截取小数位数
func FloatRound(f float64, n int) float64 {
	format := "%." + strconv.Itoa(n) + "f"
	res, _ := strconv.ParseFloat(fmt.Sprintf(format, f), 64)
	return res
}

func TestFloat_compare_13(t *testing.T) {
	var threshold1 int = 11
	var threshold2 int32 = 12
	var threshold3 int64 = 13
	threshold11 := float32(threshold1)
	threshold12 := float32(threshold2)
	threshold13 := float32(threshold3)
	fmt.Println(threshold11)
	fmt.Println(threshold12)
	fmt.Println(threshold13)
}

func TestFloat(t *testing.T) {

	if GetFloat() > C.A {
		fmt.Println("GetFloat----<")
	} else {
		fmt.Println("GetFloat----->=")
	}
}
