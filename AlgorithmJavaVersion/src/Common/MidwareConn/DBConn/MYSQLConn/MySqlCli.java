package Common.MidwareConn.DBConn.MYSQLConn;

import Common.Constant.C;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import Common.Conf.Config;
import org.junit.Test;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 蔚蔚樱
 * @version V1.0
 * @date 2022/3/12 6:21 PM
 * @author-Email micromicrohard@outlook.com
 * @description MySqlConnection 类
 */
public class MySqlCli {

    @Test
    public void TestMYSQLConn() {
        // 测试数据库连接
        new MySqlCli().SqlConnection();
    }

    /*
     *java连接mysql数据库
     *1、加载驱动程序
     *2、数据库连接字符串"jdbc:mysql://localhost:3306/数据库名?"
     *3、数据库登录名
     *3、数据库登录密码
     */
    Connection conn = null;
    public static Config config = new Config();

    public List<UTDataEntity> execQuery(String sql) throws SQLException {
        SqlConnection();
        Statement stat = (Statement) conn.createStatement();
        List<UTDataEntity> list = new ArrayList<>();
        //System.out.println(sql + ";");
        ResultSet rs = stat.executeQuery(sql);
        while (rs.next()) {
            list.add(new UTDataEntity(
                    rs.getInt("id"),
                    rs.getString("input"),
                    rs.getString("output"),
                    rs.getString("class_name"),
                    rs.getString("input_desc"),
                    rs.getString("output_desc"),
                    rs.getString("class_describe")
            ));
        }
        closeConn();
        return list;
    }

    public boolean execInsert(String sql) throws SQLException {
        SqlConnection();
        Statement stat = (Statement) conn.createStatement();
        //System.out.println(sql + ";");
        boolean flag = stat.execute(sql);
        closeConn();
        return flag;
    }

    public static String GetDBUrl() {
        return String.format("jdbc:mysql://%s:%s/%s?useUnicode=true&characterEncoding=%s",
                config.mysqlConfig.host,
                config.mysqlConfig.port,
                config.mysqlConfig.dbname,
                config.mysqlConfig.charset);//grammar:字符串拼接，String.format
    }

    public Connection SqlConnection() {
        //1.加载驱动
        try {
            Class.forName(C.mysqlVersion);
        } catch (ClassNotFoundException e) {
            System.out.println("未能成功加载驱动程序，请检查是否导入驱动程序！");
            //添加一个println，如果加载驱动异常，检查是否添加驱动，或者添加驱动字符串是否错误
            e.printStackTrace();
        }

        try {
            conn = (Connection) DriverManager.getConnection(GetDBUrl(),
                    config.mysqlConfig.username,
                    config.mysqlConfig.password);
            //System.out.println("数据库连接成功！");
        } catch (SQLException e) {
            System.out.println("数据库连接失败！");
            //添加一个println，如果连接失败，检查连接字符串或者登录名以及密码是否错误
            e.printStackTrace();
        }
        return conn;
    }

    public void closeConn() {
        //数据库打开后就要关闭
        if (conn != null) {
            try {
                conn.close();
                //System.out.println("数据库关闭成功！");
            } catch (SQLException e) {
                e.printStackTrace();
                conn = null;
            }
        }
    }
}


