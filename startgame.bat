@echo off
cd classes
javac -cp ".;./*" -sourcepath ../src -d . ../src/nullG/Main.java
if %errorlevel% == 0 (
	java -cp ".;./*" nullG.Main
	cd ..
	)