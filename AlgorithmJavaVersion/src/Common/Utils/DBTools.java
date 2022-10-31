package Common.Utils;

import Common.Constant.C;
import Common.MidwareConn.DBConn.MYSQLConn.MySqlCli;
import Common.MidwareConn.DBConn.MYSQLConn.UTDataEntity;
import Common.Conf.Config;
import Common.Utils.ToolsINTF.DBToolsINTF;
import org.junit.Test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author 蔚蔚樱
 * @version V1.0
 * @date 2022/3/12 7:10 PM
 * @author-Email micromicrohard@outlook.com
 * @description 数据库工具类
 * build sql
 * insert
 * query
 * synchronize
 */
public class DBTools implements DBToolsINTF {

    public static MySqlCli con = new MySqlCli();
    public static Config config = new Config();

    public String BuildSelectSQL(Class<?> clazz, String className) {
        if (clazz == null || className == null || className.length() == 0) {
            String sqlPattern = "SELECT * FROM %s.%s";
            return String.format(sqlPattern,
                    config.mysqlConfig.dbname,
                    config.mysqlConfig.tablename);
        }

        String sqlPattern = "SELECT * FROM %s.%s where class_name rlike %s%s%s";
        if (clazz.isInterface()) {
            sqlPattern = "SELECT * FROM %s.%s where %s%s%s rlike class_name";
        }
        String className_temp = UTFactory.reflectTools.GetClass_InterfaceName(className);
        className = "".equals(className_temp) ? className : className_temp;

        return String.format(sqlPattern,
                config.mysqlConfig.dbname,
                config.mysqlConfig.tablename,
                C.QuotationMark,
                className,
                C.QuotationMark);
    }

    public List<UTDataEntity> UTDate_Query(String sql) {
        //long start = System.currentTimeMillis();
        List<UTDataEntity> list = null;
        try {
            list = con.execQuery(sql);
        } catch (SQLException e) {
            System.out.printf("sql: %s\n", sql);
            e.printStackTrace();
        }
        //System.out.println("拉取数据耗时:" + (System.currentTimeMillis() - start) + "(ms)");
        return list;
    }

    public boolean UTData_Insert(UTDataEntity entity) {

        con = new MySqlCli();
        String sqlPattern = "insert into %s.%s (input, output, class_name, input_desc, output_desc, class_describe) values ";
        String sqlValuePattern = "(%s%s%s, %s%s%s, %s%s%s, %s, %s, %s)";

        String sql = String.format(sqlPattern,
                config.mysqlConfig.dbname,
                config.mysqlConfig.tablename);

        String sqlValue = String.format(sqlValuePattern,
                C.QuotationMarkSingle, entity.input, C.QuotationMarkSingle,
                C.QuotationMarkSingle, entity.output, C.QuotationMarkSingle,
                C.QuotationMarkSingle, entity.className, C.QuotationMarkSingle,

                Objects.equals(entity.inputDesc, null) ? null :
                        C.QuotationMarkSingle + entity.inputDesc + C.QuotationMarkSingle,
                Objects.equals(entity.outputDesc, null) ? null :
                        C.QuotationMarkSingle + entity.outputDesc + C.QuotationMarkSingle,
                Objects.equals(entity.class_describe, null) ? null :
                        C.QuotationMarkSingle + entity.class_describe + C.QuotationMarkSingle
        );

        System.out.println(sqlValue + ",");
        boolean execSuccess = false;
        try {
            execSuccess = con.execInsert(sql + sqlValue);
        } catch (SQLException e) {
            System.out.printf("sql:%s\n", sql);
            e.printStackTrace();
        }
        return execSuccess;
    }

    public void UTData_InsertBatch(UTDataEntity[] entityList) {
        for (UTDataEntity entity : entityList) {
            UTData_Insert(entity);
        }
    }

    public void UTData_InsertBatch(List<String[]> list, String className) {
        for (String[] value : list) {
            UTData_Insert(new UTDataEntity(value[0], value[1], className));
        }
    }

    @Test
    public void SynchronizationUTData() {
        // 主库数据
        // 从库数据
        // 对比
        // 插入从库
    }

    // 测试数据批量导入
    @Test
    public void insert() throws SQLException {

        String className = "Permutation";
        String[] mock_data_input = {
                "{5},{5}",
                "{0},{0}",
                "{1},{1}",
                // MockData4Mysql:正案例/反案例 分割线
        };

        String[] mock_data_output = {
                "120",
                "ErrorNum",
                "1",
        };
        List<String[]> list = new ArrayList<>();
        if (mock_data_input.length != mock_data_output.length) {
            System.out.println("入参出参数量不一致，请检查");
            return;
        }
        for (int i = 0; i < mock_data_input.length; i++) {
            list.add(new String[]{mock_data_input[i], mock_data_output[i]});
        }
        UTData_InsertBatch(list, className);
    }
}
