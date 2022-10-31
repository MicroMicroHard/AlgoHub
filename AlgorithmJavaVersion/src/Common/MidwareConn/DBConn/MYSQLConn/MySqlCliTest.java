package Common.MidwareConn.DBConn.MYSQLConn;

import org.junit.Test;

/**
 * @author 蔚蔚樱
 * @version V1.0
 * @date 2022/3/12 6:21 PM
 * @author-Email micromicrohard@outlook.com
 * @description MySqlConnection 类
 */
public class MySqlCliTest {

    @Test
    public void TestMYSQLConn() {
        // 测试数据库连接
        new MySqlCli().SqlConnection();
    }
}


