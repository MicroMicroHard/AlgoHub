"""
 * @Class: C 
 * @author: micromicrohard
 * @date: 2022/5/2220:13
 * @author—Email: micromicrohard@outlook.com
 * @description:
 * @blogURL:
"""

Min = 0
Max = 1000000
ERRORMsg = "ERROR"
ErrorNum = -999
TencentCloudVMIP = "118.195.234.62"
TRUE = "TRUE"
Error = "Error"  # 错误符号
ErrorNumStr = "ErrorNum"  # 错误数字
QuotationMark = "\""  # 引号
NULL = "Null"  # NULL表示null
EMPTY = "Empty"  # EMPTY表示空，对应int=0，String=""，数组={},结构体=new 结构体

# MYSQL 链接数据
#             "username:password@tcp(ip:port)/database?charset=utf8"
Db_ConnStr = "%s:%s@tcp(%s:%s)/%s?charset=%s"  # 数据库连接字符串
DB_IP_Local = "localhost"  # 数据库IP
DB_IP_Remote = TencentCloudVMIP  # 数据库IP
DB_Port = "3306"  # 数据库端口
DB_CharSet = "utf8"  # 数据库端口
MYSQL_Login_NAME = "mysql_user"  # 登录名
MYSQL_Login_PWD = "pwdMysql2022*"  # 密码
DB_Name = "algorithm_practice_db"  # 数据库名称
DB_TableName = "ut_test_data"  # 数据库表名

# Redis 链接数据
Redis_IP = TencentCloudVMIP
Redis_PORT = 6379
Redis_Login_PWD = "pwdRedis2022*"