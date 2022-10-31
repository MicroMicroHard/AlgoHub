package ToolsINTF

import "AlgorithmPractice/src/Common/MidwareConn/DBConn"

/**
 * @author 蔚蔚樱
 * @version V1.0
 * @date 2022/10/11 23:57
 * @author-Email micromicrohard@outlook.com
 * @description UT Data
 * GetUTData
 * PrintUTData
 * UTExecutor
 */
type UTFactoryINTF interface {
	// GetUTData
	GetUTDataEntity(utDataMap map[string][]*DBConn.UTDataEntity,
		keyName string) []*DBConn.UTDataEntity                      // 获取keyName对应的UT数据
	GetUTDataEntityAll() (map[string][]*DBConn.UTDataEntity, error) // 获取全部UT数据

	// PrintUTData
	PrintUTData(clazz interface{})

	// UTExecutor
	DoubleTrack(clazz interface{}, inputStr, outputStr string)
	UTExecutorWithPool(clazzArr []interface{})
	UTExecutorWithoutPool(clazz interface{})
	UTExecutor(clazz interface{}, utDataMap map[string][]*DBConn.UTDataEntity)
}
