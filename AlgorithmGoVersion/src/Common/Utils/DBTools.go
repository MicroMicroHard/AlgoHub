package Utils

import (
	C "AlgorithmPractice/src/Common/Constant"
	"AlgorithmPractice/src/Common/MidwareConn/DBConn"
	"AlgorithmPractice/src/Common/MidwareConn/DBConn/MySQLConn"
	"AlgorithmPractice/src/Common/conf"
	"fmt"
)

type DBConnTools struct {
	MySqlCli     *MySQLConn.DBConnMySqlCli
	MySqlCluster *MySQLConn.DBConnMySqlCluster
}

func NewDBConnTools() *DBConnTools {
	return &DBConnTools{
		MySqlCli:     MySQLConn.GetDBConnMysqlCli(),
		MySqlCluster: MySQLConn.GetDBConnMysqlCluster(),
	}
}

func (d *DBConnTools) BuildSelectSQL_Interface(className string) string {
	sqlPattern := "SELECT * FROM %s.%s where %s%s%s rlike class_name"
	sql := fmt.Sprintf(sqlPattern,
		conf.AlgorithmConf.Mysql.DBName,
		conf.AlgorithmConf.Mysql.TableName,
		C.QuotationMark, className, C.QuotationMark)
	return sql
}

func (d *DBConnTools) BuildSelectSQL(className string, isDebug bool) string {

	sqlPattern := "SELECT * FROM %s.%s where class_name = %s%s%s"
	/*switch clazz.(type) {
	case interface{}:
		sqlPattern = "SELECT * FROM %s.%s where %s%s%s rlike class_name"
	}*/
	sqlStr := fmt.Sprintf(sqlPattern,
		conf.AlgorithmConf.Mysql.DBName,
		conf.AlgorithmConf.Mysql.TableName,
		C.QuotationMark, className, C.QuotationMark)
	if isDebug {
		fmt.Println(sqlStr + "\n")
	}
	return sqlStr
}

func (d *DBConnTools) UTDate_QueryBySlaver(className string) ([]*DBConn.UTDataEntity, error) {
	/*Conn, err := NewMySqlCli()
	if err != nil {
		fmt.Println(err)
		return nil, err
	}*/
	//sqlStr := d.BuildSelectSQL(className, isDebug)
	return d.MySqlCluster.ExecQuery(className)
}

/*func (d *DBConnTools) GetAllTestData(className string) []*DBConn.UTDataEntity {
	var ans = make([]*DBConn.UTDataEntity, 0)
	// mysql grammar: Find(&ans) 此处需要传 指针，而不是：Find(ans)
	err := d.MySqlCluster.Where("class_name = ?", className).Find(&ans).Error
	if err != nil {
		fmt.Println("GetAllTestData err")
	}
	return ans
}*/

// 插入主库
func (d *DBConnTools) UTData_InsertByMaster(entity *DBConn.UTDataEntity) {
	sqlPattern := "insert into %s.%s (input,output,class_name) values (?,?,?)"
	sql := fmt.Sprintf(sqlPattern,
		conf.AlgorithmConf.Mysql.DBName,
		conf.AlgorithmConf.Mysql.TableName)
	//把user结构体的name、age字段依次传给sqlStr的占位参数
	err := d.MySqlCluster.Exec(sql, entity.Input, entity.Output, entity.ClassName).Error
	if err != nil {
		fmt.Println("GetAllTestData err:", err)
	}
}

// 插入从库
func (d *DBConnTools) UTData_InsertBySlaver(entity *DBConn.UTDataEntity) {
	d.MySqlCluster.ExecInsert(entity)
}

func (d *DBConnTools) UTData_InsertBatch() {
	/*_, err := NewMySqlCli()
	if err != nil {
		fmt.Println(err)
		return
	}*/
}

func (d *DBConnTools) SynchronizationUTData() {
	// 主库数据
	masterUTDate, err := d.MySqlCli.ExecQueryAllUTData()
	if err != nil {
		return
	}

	// 从库数据
	slaveUTDate, err := d.MySqlCluster.ExecQueryAllUTData()
	if err != nil {
		return
	}

	// 对比
	UTDataMap := make(map[string]*DBConn.UTDataEntity)
	for _, entity := range slaveUTDate {
		uniqueKey := fmt.Sprintf("%s:%s", *entity.Input, *entity.ClassName)
		if _, exist := UTDataMap[uniqueKey]; !exist {
			UTDataMap[uniqueKey] = entity
		}
	}
	index := 0
	for _, entity := range masterUTDate {
		uniqueKey := fmt.Sprintf("%s:%s", *entity.Input, *entity.ClassName)
		if _, exist := UTDataMap[uniqueKey]; !exist {
			masterUTDate[index] = entity
			index++
		}
	}
	/*if index == 0 {
		return
	}*/
	masterUTDate = masterUTDate[:index]

	// 插入指定从库
	diyDBConn := MySQLConn.NewDIYDBConnMysqlCli(
		conf.AlgorithmConf.MysqlReplicate[0].Username,
		conf.AlgorithmConf.MysqlReplicate[0].Password,
		conf.AlgorithmConf.MysqlReplicate[0].Host,
		conf.AlgorithmConf.MysqlReplicate[0].DBName,
		conf.AlgorithmConf.MysqlReplicate[0].CharSet,
		conf.AlgorithmConf.MysqlReplicate[0].Port,
	)
	err = diyDBConn.ExecBatchInsert(masterUTDate)
	if err == nil {
		fmt.Printf("SynchronizationUTData success! update %d data", len(masterUTDate))
	}

}
