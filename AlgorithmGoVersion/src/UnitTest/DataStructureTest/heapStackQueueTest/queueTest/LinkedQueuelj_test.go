package queueTest

import (
	"AlgorithmPractice/src/DataStructure/heapStackQueue/queue"
	"AlgorithmPractice/src/UnitTest/DataStructureTest/heapStackQueueTest"
	"testing"
)

func TestLinkedQueuelj(t *testing.T) {

	heapStackQueueTest.QueueljTest(t, &queue.LinkedQueuelj{})
}
