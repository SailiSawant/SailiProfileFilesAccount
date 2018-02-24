# For 9091:
# Author: Saili Sawant
# Code name: pythoncode.py

#Objectiv: To insert the records of 9091 in to the table using python

import MySQLdb                           #import statements
import datetime
<<<<<<< HEAD
conn = MySQLdb.connect("localhost","root","itmd521","itmd521sss")
=======
conn = MySQLdb.connect("localhost","root","itmd521","Week04")
>>>>>>> 3f69f83065f91d58f4114be6ec9dbb20f9af12a8
cursor = conn.cursor()
with open('9091.txt','r',encoding='latin_1') as input:
	for line in input:
		us_wthsid = line[4:10]
		wban_wthsid = line[10:15]
		observedatetime_sss = line[15:27]
		dt = datetime.datetime.strptime(observedatetime_sss,"%Y%m%d%H%M")
		latitude = line[28:34]
		longitude = line[34:41]
		elevation = line[46:51]
		wind_direc = line[61:64]
		quality_wd = line[64:65]
		sky_ceiling_hieght = line[72:76]
		quality_cde = line[76:77]
		visibility_dist = line[78:83]
		quality_vd = line[83:84]
		air_temp = line[87:92]
		quality_at = line[92:93]
		dew_point_temp = line[93:98]
		quality_dp = line[98:99]
		atmos_pressure = line[99:104]
		quality_ap = line[104:105]
		cursor.execute("INSERT INTO ninetyninetyone(us_weathersid,wban_weathersid,obsdatetime,lat,longt,elevation,wind_direction,quality_wd,skyceilinghght,quality_code,visibilitydist,quality_vd,airtemp,quality_at,dewpointtemp,qlty_dp,atmopressure,qlty_ap)VALUES(%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s)",(us_wthsid,wban_wthsid,dt.strftime("%Y-%m-%d-%H-%M"),latitude,longitude,elevation,wind_direc,quality_wd,sky_ceiling_hieght,quality_cde,visibility_dist,quality_vd,air_temp,quality_at,dew_point_temp,quality_dp,atmos_pressure,quality_ap))	
		
conn.commit()                              #commit
print ("Record added")                     #print 
conn.close()
