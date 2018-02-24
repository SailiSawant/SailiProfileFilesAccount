#!/bin/bash

sudo apt-get install -y mysql-server


#Python PAckage
sudo apt-get install python3-pip
sudo apt-get install python3-mysqldb

mysql -u root -pitmd521 -e "create database itmd521sss"

mysql -uroot -pitmd521 itmd521sss <<EOF
CREATE TABLE ninetyninetyone(
id int UNSIGNED NOT NULL AUTO_INCREMENT,
us_weathersid int,
wban_weathersid int,
obsdatetime DATETIME,
lat int,
longt int,
elevation int,
wind_direction int,
quality_wd varchar(1),
skyceilinghght int,
quality_code varchar(1),
visibilitydist int,
quality_vd varchar(1),
airtemp int,
quality_at varchar(1),
dewpointtemp int,
qlty_dp varchar(1),
atmopressure int,
qlty_ap varchar(1),
PRIMARY KEY(id));

CREATE TABLE ninetytwoninetythree(
id int UNSIGNED NOT NULL AUTO_INCREMENT,
us_weathersid int,
wban_weathersid int,
obsdatetime DATETIME,
lat int,
longt int,
elevation int,
wind_direction int,
quality_wd varchar(1),
skyceilinghght int,
quality_code varchar(1),
visibilitydist int,
quality_vd varchar(1),
airtemp int,
quality_at varchar(1),
dewpointtemp int,
qlty_dp varchar(1),
atmopressure int,
qlty_ap varchar(1),
PRIMARY KEY(id));
EOF

echo "Tables has been created"

python3 pythoncode.py
python3 pythoncode2.py
python3 pythoncode3.py
