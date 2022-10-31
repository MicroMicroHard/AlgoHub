package slidingWindowTest

import (
	"AlgorithmPractice/src/DataStructure/stringANDline/slidingWindow"
	data "AlgorithmPractice/src/UnitTest/TestDate/DataStructureTestData/stringANDlineTestData/slidingWindowTestData"
	"github.com/stretchr/testify/assert"
	"testing"
)

func TestGetAnswer(t *testing.T) {

	assertions := assert.New(t)
	as := &slidingWindow.ArraypermutationSliding{}

	list := as.GetAnswer(data.Demo01, data.Target01)
	assertions.Equal(len(list), len(data.Answer01))
	for i := 0; i < len(list); i++ {
		ans := list[i]
		target := data.Answer01[i]
		for k, v := range ans {
			assertions.Equal(v, target[k])
		}
	}

	list = as.GetAnswer(data.Demo02, data.Target02)
	assertions.Equal(len(list), len(data.Answer02))
	for i := 0; i < len(list); i++ {
		ans := list[i]
		target := data.Answer02[i]
		for k, v := range ans {
			assertions.Equal(v, target[k])
		}
	}

	list = as.GetAnswer(data.Demo03, data.Target03)
	assertions.Equal(len(list), len(data.Answer03))
	for i := 0; i < len(list); i++ {
		ans := list[i]
		target := data.Answer03[i]
		for k, v := range ans {
			assertions.Equal(v, target[k])
		}
	}

}
