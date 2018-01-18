@echo off
rem --- get date ----
set yyyy=%DATE:~0,4%
set mm=%DATE:~5,2%
set dd=%DATE:~8,2%
set curdate=%yyyy%-%mm%-%dd%

set logFileName=mvn_log_%curdate%.txt

echo -----------%curdate% %time:~0,2%:%time:~3,2%:%time:~6,2%----------- > %logFileName%


echo 正在执行maven编译...(%DATE%)

@echo 如果使用Eclipse,需要执行 mvn clean install

@rem call mvn clean install -DskipTests >> %logFileName%

call mvn clean package -DskipTests >> %logFileName%

echo 请查看日志:  %logFileName%

pause
