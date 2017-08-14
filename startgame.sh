#!/bin/bash

cd classes
javac -cp ".:./*" -sourcepath ../src -d . ../src/nullG/Main.java
if [ $? -eq 0 ]; then
    export COLUMNS LINES
    echo "Running..."
    java -cp ".:./*" nullG.Main
fi
