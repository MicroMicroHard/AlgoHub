package errors_study

import (
	"errors"
	"fmt"
	"testing"
)

func Test_Dfghj(t *testing.T) {
	var (
		err error
	)
	if err != nil {
		fmt.Println("999999show:", err)
	} else {
		fmt.Println("+++++show:", err)
	}

	err = errors.New("7777777")
	if err != nil {
		fmt.Println("---show:", err)
	} else {
		fmt.Println("+++++show:", err)
	}
}
