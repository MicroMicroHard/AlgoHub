package KafkaConn

import (
	"fmt"
	"testing"
)

// kafka_test
// @author: 蔚蔚樱
// @date: 2022/8/512:10
// @author—Email: micromicrohard@outlook.com
// @description:
// @blogURL:

func TestProducer_SendMsg(t *testing.T) {

	kafkaCli := &Producer{}
	kafkaCli.SendMsg("9876")
}

func TestProducer_ReceiveMsg(t *testing.T) {

	kafkaCli := &Consumer{}
	msg := kafkaCli.ReceiveMsg()
	fmt.Println(msg)
}
