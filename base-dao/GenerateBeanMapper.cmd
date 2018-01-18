@echo off

:begin

echo 可以使用的指令:
echo 0  --- 重新开始;
echo 1  --- 执行生成;
echo 2  --- 退出;

set ind=
set /p ind=请输入指令(0,1):


if 1 == %ind% ( goto gen )

if 0 == %ind% (goto begin)


goto end

:gen

echo 正在执行代码生成,请稍等

mvn generate-sources -P gen

echo 执行代码生成执行结束

pause

:end
