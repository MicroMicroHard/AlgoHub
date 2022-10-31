package DBConn

/**
 * @author 蔚蔚樱
 * @version V1.0
 * @date 2022/7/15 18:58
 * @author-Email micromicrohard@outlook.com
 * @description
 */
type DBConnOperationInterface interface {
	ExecQuery(sqlStr string) ([]*UTDataEntity, error)
	ExecQueryAllUTData() ([]*UTDataEntity, error)

	ExecInsert(entity *UTDataEntity)
	ExecBatchInsert(entity []*UTDataEntity)

	ExecUpdate(entity *UTDataEntity)

	PrintQuerySingleData(sqlStr string)
}
