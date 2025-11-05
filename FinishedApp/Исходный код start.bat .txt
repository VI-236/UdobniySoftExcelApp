@echo off
chcp 1251 > nul
title UdobniySoft Excel App

echo ========================================
echo   UdobniySoft Excel App - Spring Boot
echo ========================================
echo.

REM Check of jar-file exisiting
if not exist "UdobniySoftExcelApp-0.0.1-SNAPSHOT.jar" (
    echo Ошибка: Файл UdobniySoftExcelApp-0.0.1-SNAPSHOT.jar не найден!
    echo Убедитесь, что bat-файл находится в той же папке, что и jar-файл.
    pause
    exit /b 1
)

echo Spring Boot Aplication starting...
echo.

REM App start...
java -jar UdobniySoftExcelApp-0.0.1-SNAPSHOT.jar

pause