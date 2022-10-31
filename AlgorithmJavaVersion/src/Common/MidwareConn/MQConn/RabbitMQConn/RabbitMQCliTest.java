package Common.MidwareConn.MQConn.RabbitMQConn;

import org.junit.Test;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author liujun
 * @version 1.0
 * @date 2022/5/1 22:20
 * @author—Email ljfirst@mail.ustc.edu.cn
 * @description RabbitMQCliTest
 * @blogURL
 */

public class RabbitMQCliTest {

    RabbitMQCli mq = new RabbitMQCli();

    // 测试发送数数据 test send msg
    @Test
    public void TestSendMsg2RabbitMQ() throws IOException, TimeoutException {
        String msg = "hello world 3";
        for (int i = 0; i < 10; i++) {
            mq.SendMsg2RabbitMQ(msg);
        }
    }

    // 测试接受数据 test receive msg
    @Test
    public void TestReceiveMsgFromRabbitMQ() throws IOException, TimeoutException {
        mq.ReceiveMsgFromRabbitMQ();
    }

    @Test
    public void TestReceiveMsgFromRabbitMQ_BasicGet() throws IOException, TimeoutException, InterruptedException {
        mq.ReceiveMsgFromRabbitMQ_BasicGet();
    }
}
