package RedisConn

import (
	"AlgorithmPractice/src/Common/conf"
	"fmt"
	"github.com/go-redis/redis"
	"time"
)

// 声明一个全局的redisDBConn变量
// var redisDBConn *redis.Client

type CacheRedisCli struct {
	redisDBConn *redis.Client
}

// NewRedisCli 根据redis配置初始化一个客户端
func NewRedisCli() (*CacheRedisCli, error) {
	conf.GetConfig()

	redisDBConn := redis.NewClient(&redis.Options{
		Addr:     fmt.Sprintf("%s:%d", conf.AlgorithmConf.Redis.Host, conf.AlgorithmConf.Redis.Port), // redis地址
		Password: conf.AlgorithmConf.Redis.Password,                                                  // redis密码，没有则留空
		DB:       0,                                                                                  // 默认数据库，默认是0
	})

	//通过 *redis.Client.Ping() 来检查是否成功连接到了redis服务器
	_, err := redisDBConn.Ping().Result()
	if err != nil {
		return nil, err
	}
	cli := &CacheRedisCli{
		redisDBConn: redisDBConn,
	}

	fmt.Println("Redis连接成功")
	return cli, nil
}

func (c *CacheRedisCli) Set(key, value string) {
	c.SetWithTime(key, value, 0)
}

func (c *CacheRedisCli) SetWithTime(key, value string, time time.Duration) {
	err := c.redisDBConn.Set(key, value, time).Err()
	if err != nil {
		panic(err)
	}
	s := fmt.Sprintf("set key：%s, value: %s success", key, value)
	fmt.Println(s)
}

func (c *CacheRedisCli) Get(key string) {
	var value string
	// Result函数返回两个值，第一个是key的值，第二个是错误信息
	value, err := c.redisDBConn.Get(key).Result()
	// 判断查询是否出错
	if err != nil {
		panic(err)
	}
	s := fmt.Sprintf("get key：%s, value: %s success", key, value)
	fmt.Println(s)
}
