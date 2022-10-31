package MySQLConn

import (
	"AlgorithmPractice/src/Common/MidwareConn/DBConn"
	_ "github.com/go-sql-driver/mysql" // mysql grammar:在使用的地方需要隐式用到，不写会报错：err:sql: unknown driver "mysql" (forgotten import?)
	"testing"
)

func TestNewDBConnMysqlCluster(t *testing.T) {
	dbConn := GetDBConnMysqlCluster()
	df, _ := dbConn.ExecQuery("DigitalTrans")
	for _, entity := range df {
		entity.Print()
	}
}

func TestExecInsert(t *testing.T) {
	dbConn := GetDBConnMysqlCluster()
	input := "input"
	output := "output"
	class_name := "class_name1"
	dbConn.ExecInsert(&DBConn.UTDataEntity{
		Input:         &input,
		Output:        &output,
		ClassName:     &class_name,
		InputDesc:     nil,
		OutputDesc:    nil,
		ClassDescribe: nil,
	})
}
