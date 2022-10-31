from Utils.Intergration.DB.MySQL.DBMysqlCli import database2df

db_info = {
    'username': "mysql_user",
    'passwords': "pwdMysql2022*",
    'server': "118.195.234.62",
    'port': 3306,
    'database': "algorithm_practice_db"}

querySql = "SELECT * from algorithm_practice_db.ut_test_data where class_name rlike \"sort\" "

if __name__ == '__main__':
    ans = database2df(db_info, querySql)
    results = ans.fetchall()
    for ui in results:
        print(ui)
