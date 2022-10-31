package Common.Utils.ToolsINTF;

import Common.MidwareConn.DBConn.MYSQLConn.UTDataEntity;

import java.util.List;

/**
 * @author 蔚蔚樱
 * @version V1.0
 * @date 2022/10/11 23:40
 * @author-Email micromicrohard@outlook.com
 * @description build sql
 * insert
 * query
 * synchronize
 */
public interface DBToolsINTF {

    /**
     * // build sql
     * BuildSelectSQL(className string, isDebug bool) string
     * BuildSelectSQL_Interface(className string) string
     * <p>
     * // insert
     * UTData_InsertByMaster(entity *DBConn.SQLTestDataEntity)
     * UTData_InsertBySlaver(entity *DBConn.SQLTestDataEntity)
     * UTData_InsertBatch()
     * <p>
     * // query
     * UTDate_QueryBySlaver(className string) ([]*DBConn.SQLTestDataEntity, error)
     * <p>
     * // sync
     * SynchronizationUTData()
     */
    String BuildSelectSQL(Class<?> clazz, String className);//build sql

    List<UTDataEntity> UTDate_Query(String sql);       //根据类名查询测试数据

    boolean UTData_Insert(UTDataEntity entity);         //单条测试数据插入
    void UTData_InsertBatch(UTDataEntity[] entityList); //批量测试数据插入
    void UTData_InsertBatch(List<String[]> list, String className);

    void SynchronizationUTData(); // 主从同步:将主库数据同步至从库
}
