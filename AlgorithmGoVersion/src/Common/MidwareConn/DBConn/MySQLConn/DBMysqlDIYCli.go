package MySQLConn

import (
	"AlgorithmPractice/src/Common/MidwareConn/DBConn"
	"AlgorithmPractice/src/Common/conf"
	"database/sql"
	"fmt"
	"strings"
)

// DBConnMysqlDIYCli
// @author: 蔚蔚樱
// @date: 2022/7/1603:03
// @author—Email: micromicrohard@outlook.com
// @description:
// @blogURL:
type DBConnMysqlDIYCli struct {
	*sql.DB
}

func NewDIYDBConnMysqlCli(username, password, host, DBConnName, charSet string, port int) *DBConnMysqlDIYCli {
	conf.GetConfig()

	dsn := fmt.Sprintf("%s:%s@tcp(%s:%d)/%s?charset=%s",
		username, password, host, port, DBConnName, charSet,
	)
	DBConn, err := sql.Open("mysql", dsn)
	if err != nil {
		fmt.Printf("打开数据库失败,err:%v\n", err)
		return nil
	}
	err = DBConn.Ping()
	if err != nil {
		fmt.Printf("连接数据库失败,err:%v\n", err)
		return nil
	}
	fmt.Println("连接 DIY 数据库成功！")
	return &DBConnMysqlDIYCli{
		DBConn,
	}
}

func (d *DBConnMysqlDIYCli) ExecQuery(sqlStr string) ([]*DBConn.UTDataEntity, error) {
	return nil, nil
}

func (d *DBConnMysqlDIYCli) ExecQueryAllUTData() ([]*DBConn.UTDataEntity, error) {
	return nil, nil
}

func (d *DBConnMysqlDIYCli) ExecInsert(entity *DBConn.UTDataEntity) {

}

func (d *DBConnMysqlDIYCli) ExecBatchInsert(entity []*DBConn.UTDataEntity) error {
	if entity == nil || len(entity) == 0 {
		return nil
	}
	// 存放 (?, ?) 的slice
	valueStrings := make([]string, 0, len(entity))
	// 存放values的slice
	valueArgs := make([]interface{}, 0, len(entity)*2)
	// 遍历users准备相关数据
	for _, u := range entity {
		// 此处占位符要与插入值的个数对应
		valueStrings = append(valueStrings, "(?, ?, ?, ?, ?, ?)")
		valueArgs = append(valueArgs, u.Input)
		valueArgs = append(valueArgs, u.Output)
		valueArgs = append(valueArgs, u.ClassName)
		valueArgs = append(valueArgs, u.InputDesc)
		valueArgs = append(valueArgs, u.OutputDesc)
		valueArgs = append(valueArgs, u.ClassDescribe)
	}
	// 自行拼接要执行的具体语句
	stmt := fmt.Sprintf("INSERT INTO ut_test_data (`input`,`output`,`class_name`,`input_desc`,`output_desc`,`class_describe`) VALUES %s",
		strings.Join(valueStrings, ","))
	_, err := d.Exec(stmt, valueArgs...)
	if err != nil {
		fmt.Println("err :", err)
		return err
	}
	return nil
}

func (d *DBConnMysqlDIYCli) ExecUpdate(entity *DBConn.UTDataEntity) {

}

func (d *DBConnMysqlDIYCli) PrintQuerySingleData(sqlStr string) {

}
