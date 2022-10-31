package queueTest

import (
	"AlgorithmPractice/src/DataStructure/heapStackQueue/queue"
	"AlgorithmPractice/src/UnitTest/DataStructureTest/heapStackQueueTest"
	"testing"
)

func TestPriorityQueuelj(t *testing.T) {

	heapStackQueueTest.QueueljTest(t, &queue.PriorityQueuelj{})
}