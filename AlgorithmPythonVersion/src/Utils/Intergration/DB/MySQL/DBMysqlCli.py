# 读取数据库里的数据
import pandas as pd
from sqlalchemy import create_engine


def database2df(db_info, querySql):
    # 注释 grammar ''' 或者 """：相当于Java的 /** */ ，#：相当于 //
    '''将数据库的数据读取到dataframe（sql server）
    参数:
    db_info: dic
    数据库信息，包含用户名称，密码，服务器ip地址，端口，需要将资料上传到的数据库名称
    示例：
    db_info = {
    'username':username ,
    'passwords':passwords,
    'server':server,
    'port':port,
    'database':database}

    querysql：str
    sql 的查询语句

    返回：dataframe
    从数据库里面读取到的数据

    '''
    # 连接数据库
    engine = create_engine(
        'mysql+pymysql://{}:{}@{}/{}'.format(db_info['username'], db_info['passwords'],
                                             db_info['server'], db_info['database']))
    # engine = create_engine(
    #     'mssql+ymssql://{}:{}@{}:{}/{}?charset=utf8'.format(db_info['username'], db_info['passwords'],
    #                                                         db_info['server'], db_info['port'], db_info['database']))
    conn = engine.connect()

    # 读取数据
    df1 = conn.execute(querySql)

    # df = pd.read_sql_query("{}".format(querySql), conn)
    # for index in range(len(df)):
    #     print(df.get(index))

    # 关闭数据库连接
    conn.close()
    return df1
