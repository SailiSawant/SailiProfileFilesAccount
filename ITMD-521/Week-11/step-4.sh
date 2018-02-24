#!/bin/bash
#Programmed by: Saili Sawant

sqoop import --connect jdbc:mysql://localhost/hadoopguide --table widgets -m 1 --username root --password itmd521 --where "id >= 1000 and id < 3000"
