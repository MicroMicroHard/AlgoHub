package Common.MidwareConn.CacheConn.RedisConn;

import Common.Conf.Config;
import org.jredis.JRedis;
import org.jredis.RedisException;
import org.jredis.ri.alphazero.JRedisClient;

import static org.jredis.ri.alphazero.support.DefaultCodec.toStr;

/**
 * @author liujun
 * @version 1.0
 * @date 2022/4/10 19:38
 * @author—Email ljfirst@mail.ustc.edu.cn
 * @description
 * @blogURL
 */

public class RedisCli {

    public static JRedis jredis;
    public static Config config = new Config();

    public static JRedis conn() throws RedisException {
        jredis = new JRedisClient(
                config.redisConfig.host,
                config.redisConfig.port,
                config.redisConfig.password,
                0);
        System.out.println("连接成功");
        System.out.println("服务正在运行: " + jredis.ping()); //查看服务是否运行
        return jredis;
    }

    public static boolean closeRedisCli() {
        jredis.quit();
        return true;
    }

    public static String get(String key) throws RedisException {
        JRedis jredis = RedisCli.conn();
        String msg = "";
        if (jredis.exists(key)) {
            msg = toStr(jredis.get(key));
        } else {
            msg = "Redis中未查询到值";
        }
        closeRedisCli();
        return msg;
    }

    public static String set(String key, String value) throws RedisException {
        JRedis jredis = RedisCli.conn();
        jredis.set(key, value);
        closeRedisCli();
        return String.format("key:%s, value: %s success.\n", key, value);
    }
}
