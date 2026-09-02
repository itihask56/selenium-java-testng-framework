#!/bin/bash

echo "================================="
echo "Automation Execution Started"
echo "================================="

echo "Date: $(date)"

echo "Branch: $(git branch --show-current)"

echo "Java Files: $(find src -name '*.java' | wc -l)"

mvn clean test

if [ $? -eq 0 ]
then
    echo "Tests Passed"
else
    echo "Tests Failed"
    exit 1
fi

echo "Execution Complete"