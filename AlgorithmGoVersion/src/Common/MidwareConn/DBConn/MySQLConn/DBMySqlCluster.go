package MySQLConn

import (
	"AlgorithmPractice/src/Common/MidwareConn/DBConn"
	"AlgorithmPractice/src/Common/conf"
	"fmt"
	"github.com/thoas/go-funk"
	gormMysql "gorm.io/driver/mysql"
	"gorm.io/gorm"
	"gorm.io/gorm/logger"
	"gorm.io/gorm/schema"
	"gorm.io/plugin/dbresolver"
	"sync"
	"time"
)

/**
 * @author 蔚蔚樱
 * @version V1.0
 * @date 2022/7/15 21:39
 * @author-Email micromicrohard@outlook.com
 * @description
 */

var (
	batchSize                  = 500
	DBConnMySqlClusterInstance *DBConnMySqlCluster
	DBConnMySqlClusterOnce     sync.Once
)

type DBConnMySqlCluster struct {
	*gorm.DB
}

func GetDBConnMysqlCluster() *DBConnMySqlCluster {
	DBConnMySqlClusterOnce.Do(NewDBConnMysqlCluster)
	return DBConnMySqlClusterInstance
}

func NewDBConnMysqlCluster() {
	conf.GetConfig()

	DBConnMaster := fmt.Sprintf("%s:%s@tcp(%s:%d)/%s?charset=%s&parseTime=True&loc=Local&multiStatements=true&timeout=6s",
		conf.AlgorithmConf.Mysql.Username, conf.AlgorithmConf.Mysql.Password,
		conf.AlgorithmConf.Mysql.Host, conf.AlgorithmConf.Mysql.Port,
		conf.AlgorithmConf.Mysql.DBName, conf.AlgorithmConf.Mysql.CharSet)
	dbConn, err := gorm.Open(gormMysql.Open(DBConnMaster), &gorm.Config{
		Logger: logger.Default.LogMode(logger.Error),
		NamingStrategy: schema.NamingStrategy{
			SingularTable: true,
		},
	})
	if err != nil {
		fmt.Println("open dao init error :", err)
		return
	}

	DBConnInstanceClient, err := dbConn.DB()
	if err != nil {
		fmt.Println("init dao error :", err)
		return
	}

	DBConnInstanceClient.SetMaxIdleConns(10)
	DBConnInstanceClient.SetConnMaxLifetime(time.Hour)
	DBConnInstanceClient.SetConnMaxLifetime(time.Hour)
	DBConnInstanceClient.SetMaxOpenConns(10)

	replicates := make([]gorm.Dialector, 0)

	for i := 0; i < len(conf.AlgorithmConf.MysqlReplicate); i++ {
		theReplicateConfig := conf.AlgorithmConf.MysqlReplicate[i]
		readDBConnHost := fmt.Sprintf("%s:%s@tcp(%s:%d)/%s?charset=%s&parseTime=True&loc=Local&multiStatements=true&timeout=6s",
			theReplicateConfig.Username,
			theReplicateConfig.Password,
			theReplicateConfig.Host,
			theReplicateConfig.Port,
			theReplicateConfig.DBName,
			theReplicateConfig.CharSet)
		replicates = append(replicates, gormMysql.Open(readDBConnHost))
	}

	err = dbConn.Use(dbresolver.Register(dbresolver.Config{
		Sources:  []gorm.Dialector{gormMysql.Open(DBConnMaster)},
		Replicas: replicates,
		Policy:   dbresolver.RandomPolicy{},
	}))
	if err != nil {
		fmt.Println("init DBConn error :", err)
		return
	}
	fmt.Println("连接DBConn cluster数据库成功！")
	DBConnMySqlClusterInstance = &DBConnMySqlCluster{
		dbConn,
	}
	return
}

func (d *DBConnMySqlCluster) ExecQuery(class_name string) ([]*DBConn.UTDataEntity, error) {
	var (
		entityList []*DBConn.UTDataEntity
	)
	// mysql grammar: panic: reflect: call of reflect.Value.Interface on zero Value
	// mysql grammar: Find(&entityList) 此处需要传 指针，而不是：Find(entityList)
	err := d.Where("class_name = ?", class_name).Find(&entityList).Error
	if err != nil {
		fmt.Println(err)
		return nil, err
	}
	// 先精确查找，再模糊查找
	if len(entityList) == 0 {
		err = d.Where("class_name rlike ?", class_name).Find(&entityList).Error
		if err != nil {
			fmt.Println(err)
			return nil, err
		}
	}
	return entityList, nil
}

func (d *DBConnMySqlCluster) ExecQueryAllUTData() ([]*DBConn.UTDataEntity, error) {
	var (
		entityList []*DBConn.UTDataEntity
	)
	err := d.Where("id >= ?", 0).Find(&entityList).Error
	if err != nil {
		fmt.Println(err)
		return nil, err
	}
	return entityList, nil
}

func (d *DBConnMySqlCluster) ExecInsert(entity *DBConn.UTDataEntity) {
	err := d.Create(&entity).Error
	if err != nil { //执行sql语句报错
		fmt.Println("插入失败,err", err)
		return
	}
	newID := entity.ID //新插入数据的ID，默认为主键
	fmt.Println("插入成功，id为：", *newID)
}

func (d *DBConnMySqlCluster) ExecBatchInsert(entity []*DBConn.UTDataEntity) {

	batchEntity := (funk.Chunk(entity, batchSize)).([][]*DBConn.UTDataEntity)
	for _, entities := range batchEntity {
		d.BatchInsert(entities)
	}
}

func (d *DBConnMySqlCluster) BatchInsert(entity []*DBConn.UTDataEntity) {
	err := d.CreateInBatches(entity, batchSize).Error
	if err != nil { //执行sql语句报错
		fmt.Println("batch 插入失败, err", err)
		return
	}
	fmt.Println("batch 插入成功")
}

func (d *DBConnMySqlCluster) ExecUpdate(entity *DBConn.UTDataEntity) {

}

func (d *DBConnMySqlCluster) PrintQuerySingleData(className string) {
	var entity *DBConn.UTDataEntity
	err := d.Where("className = ?", className).Find(entity).Error
	if err != nil {
		fmt.Printf("获取数据错误, err:%v\n", err)
		return
	}
	fmt.Printf("查询数据成功: %#v", entity)
}
