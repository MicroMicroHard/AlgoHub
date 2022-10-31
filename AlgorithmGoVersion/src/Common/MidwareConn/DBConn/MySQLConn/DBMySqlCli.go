package MySQLConn

import (
	"AlgorithmPractice/src/Common/MidwareConn/DBConn"
	"AlgorithmPractice/src/Common/conf"
	"database/sql"
	"fmt"
	"sync"
)

/**
 * @author 蔚蔚樱
 * @version V1.0
 * @date 2022/7/15 19:06
 * @author-Email micromicrohard@outlook.com
 * @description
 */

var (
	DBConnMySqlCliInstance *DBConnMySqlCli
	DBConnMySqlCliOnce     sync.Once
)

type DBConnMySqlCli struct {
	*sql.DB
}

func GetDBConnMysqlCli() *DBConnMySqlCli {
	DBConnMySqlCliOnce.Do(NewDBConnMysqlCli)
	return DBConnMySqlCliInstance
}
func NewDBConnMysqlCli() {
	conf.GetConfig()

	dsn := fmt.Sprintf("%s:%s@tcp(%s:%d)/%s?charset=%s",
		conf.AlgorithmConf.Mysql.Username,
		conf.AlgorithmConf.Mysql.Password,
		conf.AlgorithmConf.Mysql.Host,
		conf.AlgorithmConf.Mysql.Port,
		conf.AlgorithmConf.Mysql.DBName,
		conf.AlgorithmConf.Mysql.CharSet)
	//Open打开一个driverName指定的数据库，dataSourceName指定数据源
	//不会校验用户名和密码是否正确，只会对dsn的格式进行检测
	//使用 sql.Open函数创建数据库类型，第一个是数据库驱动名，第二个是连接信息的字符串
	dbConn, err := sql.Open("mysql", dsn)
	if err != nil { //dsn格式不正确的时候会报错
		fmt.Printf("打开数据库失败,err:%v\n", err)
		return
	}
	//尝试连接数据库，Ping方法可检查数据源名称是否合法,账号密码是否正确。
	err = dbConn.Ping()
	if err != nil {
		fmt.Printf("连接数据库失败,err:%v\n", err)
		return
	}
	fmt.Println("连接数据库成功！")
	DBConnMySqlCliInstance = &DBConnMySqlCli{
		dbConn,
	}
	return
}

func (d *DBConnMySqlCli) ExecQuery(sqlStr string) ([]*DBConn.UTDataEntity, error) {
	var (
		entityList    []DBConn.UTDataEntity
		entityListPtr = make([]*DBConn.UTDataEntity, 0)
	)
	row, err := d.Query(sqlStr)
	if err != nil {
		fmt.Println("sqlStr:", sqlStr, "-------", "err:", err)
		return nil, err
	}
	for row.Next() {
		var entity DBConn.UTDataEntity

		err = row.Scan(&entity.ID, &entity.Input, &entity.Output, &entity.ClassName,
			&entity.InputDesc, &entity.OutputDesc, &entity.ClassDescribe)
		if err != nil {
			fmt.Printf("获取数据错误, err:%v\n", err)
			return nil, err
		}
		entityList = append(entityList, entity)
	}
	//fmt.Printf("查询数据成功: %#v", entityList)
	for _, entity := range entityList {
		entity_ := entity
		entityListPtr = append(entityListPtr, &entity_)
	}
	return entityListPtr, nil
}

func (d *DBConnMySqlCli) ExecQueryAllUTData() ([]*DBConn.UTDataEntity, error) {
	var (
		entityList    []DBConn.UTDataEntity
		entityListPtr = make([]*DBConn.UTDataEntity, 0)
	)
	sqlStr := fmt.Sprintf("SELECT * FROM %s.%s order by id desc", conf.AlgorithmConf.Mysql.DBName, conf.AlgorithmConf.Mysql.TableName)
	//sqlStr := "SELECT * FROM algorithm_practice_db.ut_test_data order by id desc"
	row, err := d.Query(sqlStr)
	if err != nil {
		fmt.Println("sqlStr:", sqlStr, "-------", "err:", err)
		return nil, err
	}
	for row.Next() {
		var entity DBConn.UTDataEntity
		err = row.Scan(&entity.ID, &entity.Input, &entity.Output, &entity.ClassName,
			&entity.InputDesc, &entity.OutputDesc, &entity.ClassDescribe)
		if err != nil {
			fmt.Printf("获取数据错误, err:%v\n", err)
			return nil, err
		}
		entityList = append(entityList, entity)
	}
	//fmt.Printf("查询数据成功: %#v", entityList)
	for _, entity := range entityList {
		entity_ := entity
		entityListPtr = append(entityListPtr, &entity_)
	}
	return entityListPtr, nil
}

func (d *DBConnMySqlCli) ExecInsert(entity *DBConn.UTDataEntity) {
	//需要插入的sql语句，？表示占位参数
	//sqlStr := "insert into algorithm_practice_DBConn.ut_test_data (input,output,class_name) values (?,?,?)"
	sqlPattern := "insert into %s.%s (input,output,class_name) values (?,?,?)"
	sql := fmt.Sprintf(sqlPattern,
		conf.AlgorithmConf.Mysql.DBName,
		conf.AlgorithmConf.Mysql.TableName)

	//把user结构体的name、age字段依次传给sqlStr的占位参数
	ret, err := d.Exec(sql, entity.Input, entity.Output, entity.ClassName)
	if err != nil { //执行sql语句报错
		fmt.Println("插入失败,err", err)
		return
	}
	newID, err := ret.LastInsertId() //新插入数据的ID，默认为主键
	//rowsNumber, err:= ret.RowsAffected() //受影响的行数
	if err != nil {
		fmt.Println("获取id失败,err", err)
		return
	}
	fmt.Println("插入成功，id为：", newID)
}

func (d *DBConnMySqlCli) ExecBatchInsert(entity []*DBConn.UTDataEntity) {

	//d.Exec()
}

func (d *DBConnMySqlCli) ExecUpdate(entity *DBConn.UTDataEntity) {

}

func (d *DBConnMySqlCli) PrintQuerySingleData(sqlStr string) {
	//sqlStr := "SELECT * from %s.%s WHERE where ? rlike class_name"
	sqlPattern := "SELECT * from %s.%s where class_name rlike ?"
	sqlExecStr := fmt.Sprintf(sqlPattern,
		conf.AlgorithmConf.Mysql.DBName,
		conf.AlgorithmConf.Mysql.TableName)
	fmt.Println(sqlExecStr)
	row := d.QueryRow(sqlExecStr, "className")
	var entity DBConn.UTDataEntity
	//然后使用Scan()方法给对应类型变量赋值，以便取出结果,注意传入的是指针
	err := row.Scan(&entity.ID, &entity.Input, &entity.Output, &entity.ClassName,
		&entity.InputDesc, &entity.OutputDesc, &entity.ClassDescribe)
	if err != nil {
		fmt.Printf("获取数据错误, err:%v\n", err)
		return
	}
	fmt.Printf("查询数据成功: %#v", entity)
}
