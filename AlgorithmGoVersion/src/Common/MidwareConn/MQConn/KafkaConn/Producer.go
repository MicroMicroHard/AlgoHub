package KafkaConn

import (
	"AlgorithmPractice/src/Common/conf"
	"fmt"
	"github.com/Shopify/sarama"
	"time"
)

// Producer
// @author: 蔚蔚樱
// @date: 2022/8/512:08
// @author—Email: micromicrohard@outlook.com
// @description:
// @blogURL:
type Producer struct {
}

func (p *Producer) SendMsg(params string) {

	conf.GetConfig()

	config := sarama.NewConfig()
	config.Producer.RequiredAcks = sarama.WaitForAll          // 发送完数据需要leader和follow都确认
	config.Producer.Partitioner = sarama.NewRandomPartitioner // 新选出⼀个partition
	config.Producer.Return.Successes = true                   // 成功交付的消息将在success channel返回
	// sasl认证
	/*config.Net.SASL.Enable = true
	config.Net.SASL.User = "admin"
	config.Net.SASL.Password = "admin"*/
	// 连接kafka
	client, err := sarama.NewSyncProducer([]string{fmt.Sprintf("%s:%d", conf.AlgorithmConf.Kafka.Host, conf.AlgorithmConf.Kafka.Port)}, config)
	if err != nil {
		fmt.Println("producer close, err:", err)
		return
	}

	defer client.Close()
	// 构造⼀个消息
	msg := &sarama.ProducerMessage{
		Topic:     conf.AlgorithmConf.Kafka.Topic,
		Key:       nil,
		Value:     sarama.StringEncoder(params),
		Headers:   nil,
		Metadata:  nil,
		Offset:    0,
		Partition: 0,
		Timestamp: time.Time{},
	}
	// 发送消息
	pid, offset, err := client.SendMessage(msg)
	if err != nil {
		fmt.Println("send message failed,", err)
		return
	}
	fmt.Printf("pid:%v offset:%v\n", pid, offset)
}
