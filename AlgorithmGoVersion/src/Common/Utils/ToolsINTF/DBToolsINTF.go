package ToolsINTF

import "AlgorithmPractice/src/Common/MidwareConn/DBConn"

/**
 * @author 蔚蔚樱
 * @version V1.0
 * @date 2022/10/11 23:40
 * @author-Email micromicrohard@outlook.com
 * @description
 * build sql
 * insert
 * query
 * synchronize
 */
type DBToolsINTF interface {
	// build sql
	BuildSelectSQL(className string, isDebug bool) string
	BuildSelectSQL_Interface(className string) string

	// insert
	UTData_InsertByMaster(entity *DBConn.UTDataEntity)
	UTData_InsertBySlaver(entity *DBConn.UTDataEntity)
	UTData_InsertBatch()

	// query
	UTDate_QueryBySlaver(className string) ([]*DBConn.UTDataEntity, error)

	// sync
	SynchronizationUTData() // 主从同步
}
