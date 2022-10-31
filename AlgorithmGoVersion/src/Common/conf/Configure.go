package conf

import (
	C "AlgorithmPractice/src/Common/Constant"
	"fmt"
	"github.com/spf13/viper"
	"os"
	"path/filepath"
	"strings"
	"sync"
)

/**
 * @author 蔚蔚樱
 * @version V1.0
 * @date 2022/6/25 12:36 上午
 * @author-Email micromicrohard@outlook.com
 * @description
 */

var (
	AlgorithmConf *Config
	Once          sync.Once
)

func GetConfig() {
	Once.Do(initConfig)
}

func initConfig() {
	config := viper.New()

	path := "/../config/"
	wd, err := os.Getwd()
	if err != nil {
		fmt.Println(err)
		return
	}
	pathSplit := strings.Split(wd, C.ProjectName)
	if len(pathSplit) < 2 {
		fmt.Println(pathSplit)
		return
	}

	path = filepath.Join(pathSplit[0], path)

	config.AddConfigPath(path)
	config.SetConfigName("config")
	config.SetConfigType("yaml")

	if err = config.ReadInConfig(); err != nil {
		if _, ok := err.(viper.ConfigFileNotFoundError); ok {
			fmt.Println("找不到配置文件..")
		} else {
			fmt.Println("配置文件出错..")
		}
	}

	/*allSettings := config.AllSettings()
	fmt.Println(allSettings)*/

	AlgorithmConf = &Config{}

	if err = config.Unmarshal(AlgorithmConf); err != nil {
		// yaml grammar: 注意 yaml 数组的写法
		fmt.Println(err)
	}
}

type Config struct {
	Common         CommonConfig      `json:"common"   yaml:"common"` // json grammar: 首字母大写，字段名称和json一致，差个下划线也不行
	Mysql          DataBasesConfig   `json:"mysql"    yaml:"mysql"`
	MysqlReplicate []DataBasesConfig `json:"mysqlreplicate" yaml:"mysqlreplicate"`
	Redis          RedisConfig       `json:"redis"    yaml:"redis"`
	Kafka          KafkaConfig       `json:"kafka"    yaml:"kafka"`
	RabbitMQ       RabbitMQConfig    `json:"rabbitmq" yaml:"rabbitmq"`
}

type CommonConfig struct {
	MaxValueExpr string `json:"MaxValueExpr" yaml:"MaxValueExpr"`
	MinValueExpr string `json:"MinValueExpr" yaml:"MinValueExpr"`
	TRUEExpr     string `json:"TRUEExpr"     yaml:"TRUEExpr"`
	FalseExpr    string `json:"FalseExpr"    yaml:"FalseExpr"`
	ErrorExpr    string `json:"ErrorExpr"    yaml:"ErrorExpr"` // 错误符号
	NullExpr     string `json:"NullExpr"     yaml:"NullExpr"`  // Nil表示null
	EmptyExpr    string `json:"EmptyExpr"    yaml:"EmptyExpr"` // Empty表示空，对应int = 0，String = ""，数组 = {}, 结构体 = new(结构体)
	NLF          string `json:"NLF"          yaml:"NLF"`
	SpiltExpr    string `json:"spilt_expr"   yaml:"spilt_expr"`
}

type DataBasesConfig struct {
	DBName    string `json:"dbname"    yaml:"dbname"`
	TableName string `json:"tablename" yaml:"tablename"` // key 带下划线的无法识别
	Host      string `json:"host"      yaml:"host"`
	Port      int    `json:"port"      yaml:"port"`
	Username  string `json:"username"  yaml:"username"`
	Password  string `json:"password"  yaml:"password"`
	CharSet   string `json:"charset"   yaml:"charset"`
}

type RedisConfig struct {
	Host     string `json:"host"     yaml:"host"`
	Port     int    `json:"port"     yaml:"port"`
	Password string `json:"password" yaml:"password"`
}

type KafkaConfig struct {
	Host  string `json:"host"  yaml:"host"`
	Port  int    `json:"port"  yaml:"port"`
	Topic string `json:"topic" yaml:"topic"`
}

type RabbitMQConfig struct {
	Host     string `json:"host"     yaml:"host"`
	Port     int    `json:"port"     yaml:"port"`
	Topic    string `json:"topic"    yaml:"topic"`
	UserName string `json:"username" yaml:"username"`
	Password string `json:"password" yaml:"password"`
	Exchange string `json:"exchange" yaml:"exchange"`
	RouteKey string `json:"routeKey" yaml:"routeKey"`
}
