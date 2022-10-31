package MySQLConn

import (
	_ "github.com/go-sql-driver/mysql" // go grammar:在使用的地方需要隐式用到，不写会报错：err:sql: unknown driver "mysql" (forgotten import?)
	"testing"
)

func TestNewMySqlConnection(t *testing.T) {
	DBConn := GetDBConnMysqlCli()
	df, _ := DBConn.ExecQuery("SELECT * FROM algorithm_practice_db.ut_test_data where class_name = \"TheLeastNeighbors\"")
	for _, entity := range df {
		entity.Print()
	}
}

func TestExecQueryAllUTData(t *testing.T) {
	DBConn := GetDBConnMysqlCli()
	df, _ := DBConn.ExecQueryAllUTData()
	for _, entity := range df {
		entity.Print()
	}
}
