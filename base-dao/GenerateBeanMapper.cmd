@echo off

:begin

echo ����ʹ�õ�ָ��:
echo 0  --- ���¿�ʼ;
echo 1  --- ִ������;
echo 2  --- �˳�;

set ind=
set /p ind=������ָ��(0,1):


if 1 == %ind% ( goto gen )

if 0 == %ind% (goto begin)


goto end

:gen

echo ����ִ�д�������,���Ե�

mvn generate-sources -P gen

echo ִ�д�������ִ�н���

pause

:end
