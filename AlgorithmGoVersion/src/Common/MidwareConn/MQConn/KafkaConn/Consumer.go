package KafkaConn

import (
	"AlgorithmPractice/src/Common/conf"
	"fmt"
	"github.com/Shopify/sarama"
)

// Consumer
// @author: 蔚蔚樱
// @date: 2022/8/512:07
// @author—Email: micromicrohard@outlook.com
// @description:
// @blogURL:
type Consumer struct {
}

func (p *Consumer) ReceiveMsg() string {

	conf.GetConfig()

	consumeMsg := make([]string, 0)

	config := sarama.NewConfig()
	config.Consumer.Return.Errors = true
	config.Version = sarama.V0_11_0_2
	/*config.Net.SASL.Enable = true
	config.Net.SASL.User = "admin"
	config.Net.SASL.Password = "admin"*/
	// consumer
	consumer, err := sarama.NewConsumer([]string{fmt.Sprintf("%s:%d", conf.AlgorithmConf.Kafka.Host, conf.AlgorithmConf.Kafka.Port)}, config)
	if err != nil {
		fmt.Printf("consumer_test create consumer error %s\n", err.Error())
		return ""
	}
	partitionList, err := consumer.Partitions(conf.AlgorithmConf.Kafka.Topic) // 根据topic取到所有的分区
	if err != nil {
		fmt.Printf("fail to get list of partition:err%v\n", err)
		return ""
	}
	defer consumer.Close()
	for partition := range partitionList {
		partitionConsumer, err := consumer.ConsumePartition(conf.AlgorithmConf.Kafka.Topic, int32(partition), sarama.OffsetOldest)
		if err != nil {
			fmt.Printf("try create partition_consumer error %s\n", err.Error())
			return ""
		}
		defer partitionConsumer.Close()
		for {
			select {
			case msg := <-partitionConsumer.Messages():
				consumeMsg = append(consumeMsg, string(msg.Value))
				fmt.Printf("msg offset: %d, partition: %d, timestamp: %s, value: %s\n",
					msg.Offset, msg.Partition, msg.Timestamp.String(), string(msg.Value))
			case err := <-partitionConsumer.Errors():
				fmt.Printf("err :%s\n", err.Error())
			}
		}
	}
	return ""
}
