@echo off
color 0A

:Step1
cls
echo.
echo. Compilation of Server
echo.
echo. 1 - Compile
echo.

set Step1prompt=x
set /p Step1prompt= Your choise :
if /i %Step1prompt%==1 goto Compile
goto Step1


:Compile
@cls
title Compile
color 0A
echo.
echo Compilation process. Please wait...
ant -f build.xml -l Compile.log
echo Compilation successful!!!
pause

:fullend