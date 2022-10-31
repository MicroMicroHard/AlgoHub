package A_____practice

import (
	C "AlgorithmPractice/src/Common/Constant"
	"fmt"
	"testing"
)

type Request struct {
	Type *int64
}

func TestY1YY(t *testing.T) {

	reqType := int64(C.OneWayBill2ManyDriver)
	yy := &Request{
		Type: &reqType,
	}

	uu := yy.Type

	fmt.Println("555555")
	switch *uu {
	case int64(C.OneWayBill2ManyDriver):
		fmt.Println("----")
	case 2:
		fmt.Println("1111")
	default:
		fmt.Println("33333")
	}
}
