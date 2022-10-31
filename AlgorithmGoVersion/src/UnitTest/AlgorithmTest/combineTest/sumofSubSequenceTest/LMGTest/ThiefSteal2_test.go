package LMGTest

import (
	"AlgorithmPractice/src/Algorithm/comprehensive/sumofSubSequence/LMG"
	"github.com/stretchr/testify/assert"
	"testing"
)

func TestThiefSteal2(t *testing.T) {

	thief := &LMG.ThiefSteal2{}
	assertions := assert.New(t)

	assertions.Equal(thief.Method(demo00), 0)
	assertions.Equal(thief.Method(demo01), 210)
	assertions.Equal(thief.Method(demo02), 30)
	assertions.Equal(thief.Method(demo03), 210)
	assertions.Equal(thief.Method(demo04), 105)
	assertions.Equal(thief.Method(demo05), 105)
	assertions.Equal(thief.Method(demo06), 630)
	assertions.Equal(thief.Method(demo07), 126)
	assertions.Equal(thief.Method(demo08), -5)
	assertions.Equal(thief.Method(demo09), 2)
	assertions.Equal(thief.Method(demo10), 30)
	assertions.Equal(thief.Method(demo101), 2)
	assertions.Equal(thief.Method(demo11), 30)
	assertions.Equal(thief.Method(demo12), 90)
	assertions.Equal(thief.Method(demo13), 30)
	assertions.Equal(thief.Method(demo14), 126)
	assertions.Equal(thief.Method(demo15), 630)
	assertions.Equal(thief.Method(demo16), 630)
	assertions.Equal(thief.Method(demo17), 630)
}
