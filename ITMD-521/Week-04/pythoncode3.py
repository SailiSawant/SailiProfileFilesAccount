#Code name: pythoncode3.py
#Programmed by: Saili Sawant

import MySQLdb              #import Statements
import datetime
<<<<<<< HEAD
conn = MySQLdb.connect(user='root', passwd='itmd521',db='itmd521sss',host='127.0.0.1')
=======
conn = MySQLdb.connect(user='root', passwd='itmd521',db='Week04',host='127.0.0.1')
>>>>>>> 3f69f83065f91d58f4114be6ec9dbb20f9af12a8
cursor = conn.cursor()
print ("Running Successfully");

cursor.execute("SELECT year(obsdatetime) AS YEAR, max(airtemp) AS MaximumTemp from ninetyninetyone WHERE airtemp != 9999 AND (quality_at = '0' || quality_at = '1' || quality_at= '4' || quality_at = '5' || quality_at = '9') GROUP BY year(obsdatetime);")


row = cursor.fetchone()
while row:
        print("Year = " +str(row[0])+ " ~~~~~~~~ MaximumTemp = " +str(row[1]));
        row = cursor.fetchone()

cursor.execute("SELECT year(obsdatetime) AS Year, max(airtemp) AS MaximumTemp from ninetytwoninetythree WHERE airtemp != 9999 AND (quality_at = '0' || quality_at = '1' || quality_at = '4' || quality_at = '5' || quality_at= '9') GROUP BY year(obsdatetime);")

row = cursor.fetchone()
while row:
        print("Year = " +str(row[0])+ " ~~~~~~~~ MaximumTemp = " +str(row[1]));
        row = cursor.fetchone()
conn.commit()
conn.close()
