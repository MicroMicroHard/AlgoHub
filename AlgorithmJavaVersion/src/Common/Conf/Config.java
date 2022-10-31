package Common.Conf;

import Common.Constant.C;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

public class Config {

    public CommonConfig commonConfig;
    public RedisConfig redisConfig;
    public MysqlConfig mysqlConfig;
    public RabbitMQConfig rabbitMqConfig;
    public KafkaConfig kafkaConfig;

    public Config() {

        Map<String, Object> configMap = initConfig();
        Object commonConfigMap = configMap.getOrDefault("common", null);
        if (commonConfigMap != null) {
            this.commonConfig = GetCommonConfig((Map) commonConfigMap);
        }

        Object mysqlConfigMap = configMap.getOrDefault("mysql", null);
        if (mysqlConfigMap != null) {
            this.mysqlConfig = GetMysqlConfig((Map) mysqlConfigMap);
        }

        Object redisConfigMap = configMap.getOrDefault("redis", null);
        if (redisConfigMap != null) {
            this.redisConfig = GetRedisConfig((Map) redisConfigMap);
        }

        Object rabbitMQConfigMap = configMap.getOrDefault("rabbitmq", null);
        if (rabbitMQConfigMap != null) {
            this.rabbitMqConfig = GetRabbitMQConfig((Map) rabbitMQConfigMap);
        }

        Object kafkaMQConfigMap = configMap.getOrDefault("kafka", null);
        if (kafkaMQConfigMap != null) {
            this.kafkaConfig = GetKafkaConfig((Map) kafkaMQConfigMap);
        }
    }

    public String GetConfigurePath() {
        File directory = new File("");// 参数为空
        String path = "";
        try {
            //sourceFile = System.getProperty("user.dir");
            path = directory.getAbsolutePath() + "/../../config/config.yaml";//reflect grammar：获取项目的绝对路径
        } catch (Exception e) {
            e.printStackTrace();
        }
        return path;
    }

    public Map initConfig() {
        InputStream in = null;
        String path = GetConfigurePath();
        try {
            Yaml yaml = new Yaml();
            in = Files.newInputStream(Paths.get(path)); // yaml文件路径
            return yaml.load(in);
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage(), e);
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    throw new RuntimeException(e.getMessage(), e);
                }
            }
        }
    }


    public class CommonConfig {
        public String MaxValueExpr;     //`json:"MinValue"yaml:"MinValue"`
        public String MinValueExpr;     //`json:"MinValue"yaml:"MinValue"`
        public String TrueExpr;         //`json:"TRUE"yaml:"TRUE"`
        public String FalseExpr;        //`json:"TRUE"yaml:"TRUE"`
        public String ErrorExpr;        //`json:"Error"yaml:"Error"` // 错误符号
        public String NullExpr;         //`json:"NULL"yaml:"NULL"`   // NULL表示null
        public String EmptyExpr;        //`json:"EMPTY"yaml:"EMPTY"` // EMPTY表示空，对应int = 0，String = ""，数组 = {}, 结构体 = new(结构体)
        public String SpiltExpr;
        public String NLF;              // NLF = NullLeafSymbol:表示空叶子结点
    }

    public CommonConfig GetCommonConfig(Map map) {
        if (map == null || map.size() == 0) {
            return null;
        }
        CommonConfig Common = new CommonConfig();
        Common.MaxValueExpr = (String) map.getOrDefault("MaxValueExpr", "");
        Common.MinValueExpr = (String) map.getOrDefault("MinValueExpr", "");
        Common.TrueExpr = (String) map.getOrDefault("TrueExpr", "");
        Common.FalseExpr = (String) map.getOrDefault("FalseExpr", "");
        Common.ErrorExpr = (String) map.getOrDefault("ErrorExpr", "");
        Common.NullExpr = (String) map.getOrDefault("NullExpr", "");
        Common.EmptyExpr = (String) map.getOrDefault("EmptyExpr", "");
        Common.SpiltExpr = (String) map.getOrDefault("SpiltExpr", "");
        Common.NLF = (String) map.getOrDefault("NLF", "");
        return Common;
    }


    public class MysqlConfig {
        public String host;        //`json:"host"yaml:"host"`
        public int port;           //`json:"port"yaml:"port"`
        public String dbname;      //`json:"dbname"yaml:"dbname"`
        public String tablename;   //`json:"tablename"yaml:"tablename"` // key 带下划线的无法识别
        public String username;    //`json:"username"yaml:"username"`
        public String password;    //`json:"password"yaml:"password"`
        public String charset;     //`json:"charset"yaml:"charset"`
        public boolean useLocalDB; //`json:"charset"yaml:"useLocalDB"`  // 使用本地数据库
    }

    public MysqlConfig GetMysqlConfig(Map map) {
        if (map == null || map.size() == 0) {
            return null;
        }
        MysqlConfig mysqlConfig = new MysqlConfig();
        mysqlConfig.host = (String) map.getOrDefault("host", "");
        mysqlConfig.port = (int) map.getOrDefault("port", "");
        mysqlConfig.dbname = (String) map.getOrDefault("dbname", "");
        mysqlConfig.tablename = (String) map.getOrDefault("tablename", "");
        mysqlConfig.username = (String) map.getOrDefault("username", "");
        mysqlConfig.password = (String) map.getOrDefault("password", "");
        mysqlConfig.charset = (String) map.getOrDefault("charset", "");
        mysqlConfig.useLocalDB = (boolean) map.getOrDefault("useLocalDB", false);
        if (C.useLocalDB || mysqlConfig.useLocalDB) {
            mysqlConfig.host = "localhost";
            mysqlConfig.username = "root";
            mysqlConfig.password = "12345678";
        }
        return mysqlConfig;
    }

    public class RedisConfig {
        public String host;        //`json:"host"yaml:"host"`
        public int port;           //`json:"port"yaml:"port"`
        public String username;    //`json:"username"yaml:"username"`
        public String password;    //`json:"username"yaml:"password"`
        public String exchange;    //`json:"username"yaml:"exchange"`
        public String queue;       //`json:"username"yaml:"queue"`
        public String routeKey;    //`json:"username"yaml:"routeKey"`
    }

    public RedisConfig GetRedisConfig(Map map) {
        if (map == null || map.size() == 0) {
            return null;
        }
        RedisConfig redisConfig = new RedisConfig();
        redisConfig.host = (String) map.getOrDefault("host", "");
        redisConfig.port = (int) map.getOrDefault("port", 0);
        redisConfig.password = (String) map.getOrDefault("password", "");
        return redisConfig;
    }

    public class RabbitMQConfig {
        public String host;          //`json:"host"yaml:"host"`
        public int port;             //`json:"port"yaml:"port"`
        public String username;      //`json:"username"yaml:"username"`
        public String password;      //`json:"password"yaml:"password"`
        public String exchange;      //`json:"exchange"yaml:"exchange"`
        public String queue;         //`json:"queue"yaml:"queue"`
        public String routingkey;    //`json:"routeKey"yaml:"routeKey"`
    }

    public RabbitMQConfig GetRabbitMQConfig(Map map) {
        if (map == null || map.size() == 0) {
            return null;
        }
        RabbitMQConfig rabbitMQConfig = new RabbitMQConfig();
        rabbitMQConfig.host = (String) map.getOrDefault("host", "");
        rabbitMQConfig.port = (int) map.getOrDefault("port", 0);
        rabbitMQConfig.username = (String) map.getOrDefault("username", "");
        rabbitMQConfig.password = (String) map.getOrDefault("password", "");
        rabbitMQConfig.exchange = (String) map.getOrDefault("exchange", "");
        rabbitMQConfig.queue = (String) map.getOrDefault("queue", "");
        rabbitMQConfig.routingkey = (String) map.getOrDefault("routeKey", "");
        return rabbitMQConfig;
    }

    public class KafkaConfig {
        public String host;          //`json:"host"yaml:"host"`
        public int port;             //`json:"port"yaml:"port"`
        public String topic;         //`json:"topic"yaml:"topic"`
    }

    public KafkaConfig GetKafkaConfig(Map map) {
        if (map == null || map.size() == 0) {
            return null;
        }
        KafkaConfig kafkaConfig = new KafkaConfig();
        kafkaConfig.host = (String) map.getOrDefault("host", "");
        kafkaConfig.port = (int) map.getOrDefault("port", 0);
        kafkaConfig.topic = (String) map.getOrDefault("topic", "");
        return kafkaConfig;
    }

}
