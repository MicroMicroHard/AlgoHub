import pymysql

username = "mysql_user"
passwords = "pwdMysql2022*",
serverHost = "118.195.234.62",
port = 3306,
database = "algorithm_practice_db"

try:
    db = pymysql.connect(host="118.195.234.62", user=username, password="pwdMysql2022*", database=database,
                         charset="utf8")
    print("数据库连接成功")
except pymysql.Error as e:
    print("数据库连接失败：" + str(e))
