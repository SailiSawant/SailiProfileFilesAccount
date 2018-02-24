#!bin/bash

# Code Written by: Saili Sawant

<<<<<<< HEAD
<<<<<<< HEAD
mysql -uroot -pitmd521 itmd521sss <<EOF
=======
mysql -uroot -pitmd521 Week04 <<EOF
>>>>>>> 3f69f83065f91d58f4114be6ec9dbb20f9af12a8
=======
mysql -uroot -pitmd521 Week0 <<EOF
>>>>>>> 9a1c07a4ecdf62d55cf53b0b4bf92f1beddaea62

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
