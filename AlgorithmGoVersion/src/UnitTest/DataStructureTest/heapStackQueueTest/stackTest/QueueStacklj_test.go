package stackTest

import (
	"AlgorithmPractice/src/DataStructure/heapStackQueue/stack"
	"AlgorithmPractice/src/UnitTest/DataStructureTest/heapStackQueueTest"
	"testing"
)

func TestQueueStacklj(t *testing.T) {

	heapStackQueueTest.StackljTest(t, &stack.QueueStacklj{})
}