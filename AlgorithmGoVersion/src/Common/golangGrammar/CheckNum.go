package golangGrammar

import (
	"fmt"
	"strconv"
)

// CheckNum
// @author: 蔚蔚樱
// @date: 2022/5/2522:10
// @author—Email: micromicrohard@outlook.com
// @description:
// @blogURL:
type CheckNum struct {
}

func (p *CheckNum) CheckNumMethod(argx string) bool {
	val, err := strconv.Atoi(argx) // grammar check string is num or not
	if err != nil {
		fmt.Printf("Supplied value %s is not a number\n", argx)
		return false
	}
	fmt.Printf("Supplied value %s is a number with value %d\n", argx, val)
	return true
}
