package RedisConn

import (
	"testing"
)

func TestRedisCli(t *testing.T) {
	_, err := NewRedisCli()
	if err != nil {
		//redis连接错误
		panic(err)
	}
}

func TestSet(t *testing.T) {
	redisTestStr := "redisTestStr"
	redisCli, err := NewRedisCli()
	if err != nil {
		//redis连接错误
		panic(err)
	}

	redisCli.Set(redisTestStr, "lisi")
	redisCli.SetWithTime(redisTestStr, "lisi", 0)
	redisCli.Get(redisTestStr)
}
