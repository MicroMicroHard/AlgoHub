package Common.MidwareConn.MQConn.RabbitMQConn;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.*;
import Common.Conf.Config;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2022/5/1 22:20
 * @author—Email micromicrohard@outlook.com
 * @description RabbitMQ
 * RabbitMQCli提供三个基础方法:获取连接、发送消息、接受消息
 * {@link RabbitMQCli#getConnection}
 * {@link RabbitMQCli#SendMsg2RabbitMQ}
 * {@link RabbitMQCli#ReceiveMsgFromRabbitMQ}
 * {@link RabbitMQCli#ReceiveMsgFromRabbitMQ_BasicGet()}
 * @blogURL
 */

public class RabbitMQCli {

    static Config config = new Config();

    public void SendMsg2RabbitMQ(String msg) throws IOException, TimeoutException {
        //获取连接
        Connection connection = getConnection();
        //mq提供Channel来将处理消息,创建Channel
        Channel channel = connection.createChannel();
        //basicPublish将消息发送到指定的交换机
        channel.basicPublish(
                config.rabbitMqConfig.exchange,
                config.rabbitMqConfig.routingkey,
                MessageProperties.PERSISTENT_TEXT_PLAIN,
                msg.getBytes());
        //关闭连接
        channel.close();
        connection.close();
    }

    // rabbitmq grammar: 此方法启动的时候，在RabbitMQ 控制台的 connections里面可以看到一个连接
    public void ReceiveMsgFromRabbitMQ_BasicGet() throws IOException, TimeoutException, InterruptedException {
        //获取与MQ的连接
        Connection connection = getConnection();
        //创建Channel
        Channel channel = connection.createChannel();
        while (true) {
            //拉一条，自动确认的(rabbit 认为这条消息消费 -- 从队列中删除)
            GetResponse getResponse = channel.basicGet(config.rabbitMqConfig.queue, false);
            if (null != getResponse) {
                System.out.println("received["
                        + getResponse.getEnvelope().getRoutingKey() + "]"
                        + new String(getResponse.getBody()));
            }
            //确认(自动、手动)
            channel.basicAck(0, true);
            Thread.sleep(1000);
        }
    }

    public void ReceiveMsgFromRabbitMQ() throws IOException, TimeoutException {
        //获取与MQ的连接
        Connection connection = getConnection();
        //创建Channel
        Channel channel = connection.createChannel();
        //通过basicConsumer方法从指定队列中获取消息，消息生产者会通过ex2交换机中的key值将消息发送到queue6中，因为在创建queue6时绑定到交换机ex3中，指定的路由键为a。

        //获取Consumer
        Consumer consumer = new DefaultConsumer(channel) {
            //重写handleDelivery方法（这个方法是消息的处理过程）
            //body参数就是接受到的消息
            
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                //将消息转换成String类型然后打印
                String msg = new String(body);
                System.out.println(msg);
            }
        };
        //consumer参数是消息接收之后的处理方法
        channel.basicConsume(config.rabbitMqConfig.queue, false, consumer);
    }

    public static Connection getConnection() throws IOException, TimeoutException {
        //1.创建连接工厂
        ConnectionFactory factory = new ConnectionFactory();//MQ采用工厂模式来完成连接的创建
        //2.在工厂对象中设置连接信息(ip,port,virtualhost,username,password)
        factory.setHost(config.rabbitMqConfig.host);//设置MQ安装的服务器ip地址
        factory.setPort(config.rabbitMqConfig.port);//设置端口号
        factory.setVirtualHost("/");//设置虚拟主机名称
        //MQ通过用户来管理
        factory.setUsername(config.rabbitMqConfig.username);//设置用户名称
        factory.setPassword(config.rabbitMqConfig.password);//设置用户密码
        //3.通过工厂对象获取连接
        Connection connection = factory.newConnection();
        return connection;
    }
}
