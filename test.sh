#!/bin/bash

echo "Starting Automation Suite..."

mvn clean test

if [ $? -eq 0 ]
then
    echo "Test Execution Successful"
else
    echo "Test Execution Failed"
    exit 1
fi

echo "Generating Report..."

echo "Done!"