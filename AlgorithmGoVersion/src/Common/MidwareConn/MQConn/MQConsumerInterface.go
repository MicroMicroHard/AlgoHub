package MQConn

// MQInterface
// @author: 蔚蔚樱
// @date: 2022/8/816:43
// @author—Email: micromicrohard@outlook.com
// @description:
// @blogURL:

type MQConsumerInterface interface {
	ReceiveMsg() string // Consumer
}
