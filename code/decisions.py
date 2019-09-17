import sqlite3


def IsConflict(item,countrycode):
    status = True
    resources = "gold","silver","diamond"
    conflictCountries = "SE","NO","DK"

    if item not in resources:
        status = False
        return status
    else:
        if countrycode in conflictCountries:
            return status

def create_connection(db_file):
    conn = None
    try:
        conn = sqlite3.connect(db_file)
        return conn
        print(sqlite3.version)
    except Error as e:
        print(e)

def create_table(db_file):
    conn = create_connection(db_file)
    sql = """create table if not exists data(
    id integer,
    emission integer,
    actor text,
    action text,
    vehicle text,
    lastmnts integer)"""

    c = conn.cursor()
    c.execute(sql)
    conn.commit()

    #saves predefined input parameters to calculate aproximate co2 emissions