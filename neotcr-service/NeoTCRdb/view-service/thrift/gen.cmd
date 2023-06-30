@echo off
echo gen Python Thrift program file
thrift --gen py -out ../ view.thrift
thrift --gen java -out ../../view-client/src/main/java view.thrift