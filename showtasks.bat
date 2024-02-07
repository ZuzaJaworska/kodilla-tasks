call runcrud.bat
if "%ERRORLEVEL%" == "0" goto openbrowser
echo.
echo There were problems with running runcrud.bat
goto fail

:openbrowser
echo.
echo Starting Google Chrome...
start chrome http://localhost:8080/crud/v1/tasks
if "%ERRORLEVEL%" == "0" goto end
echo There were problems with running Google Chrome
goto fail

:fail
echo.
echo There were errors

:end
echo.
echo Work is finished