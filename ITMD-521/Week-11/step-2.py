#Programmed by: Saili Sawant
#Program Name : step-2.py

import MySQLdb                                      # Import statement
import random
widgetnm=['sprocket', 'gizmo', 'gadget']            #Widget name
designdte=['2010-02-10', '2009-11-30', '1983-08-13'] #Design Date
ver=['1','4','13']                                   #Version  
designcomm=['Connects two gizmos','null','Our flagship product'] #Design comment 
conn = MySQLdb.connect("localhost","root","itmd521","hadoopguide")    # Connection to MySQLdb
cursor = conn.cursor()
for count in range(5000):
    wid_nm = random.choice(widgetnm)
    price=round(random.uniform(1,100),2) #Create a random price 
    desgn_dt = random.choice(designdte)
    version=random.choice(ver)
    desgn_comm=random.choice(designcomm)
    cursor.execute("INSERT INTO widgets (widget_name,price,design_date,version,design_comment)VALUES (%s,%s,%s,%s,%s)",(wid_nm,price,desgn_dt,version,desgn_comm))   #Insert into Table widgets
conn.commit()
print ("Records added in Widgets")
conn.close()  
