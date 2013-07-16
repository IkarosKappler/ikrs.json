#!/bin/sh
#
# @author Ikaros Kappler
# @date 2013-07-16
# @version 1.0.0


# Check file argument?
# if [ "$1" = "" ]; then
#    echo "Please pass the input file"
#    exit 1
# fi


# Compile ikrs.json
echo "Compile ikrs.json (and sub packages) ..."
javac -Xlint:none ikrs/json/*.java ikrs/json/parser/*.java ikrs/json/rpc/*.java
ec="$?"
if [ "$ec" -ne "0" ]; then
    echo "Sorry, failed to compile ikrs.json. Exit code $ec"
    exit 1
fi