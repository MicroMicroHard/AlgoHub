package Common.MidwareConn.CacheConn.RedisConn;


import org.jredis.RedisException;
import org.junit.Test;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2022/5/1 22:22
 * @author—Email micromicrohard@outlook.com
 * @description
 * @blogURL
 */

public class RedisCliTest {

    String redisTestStr = "redisTestStr";

    // 测试接受数据 test receive msg
    @Test
    public void ReceiveMsgFromRedis() throws RedisException {
        String value = RedisCli.set(redisTestStr, "1113");
        System.out.println(value);
    }

    // 测试发送数数据 test send msg
    @Test
    public void sendMsg2Redis() throws RedisException {
        String value = RedisCli.get(redisTestStr);
        System.out.println(value);
    }
}
