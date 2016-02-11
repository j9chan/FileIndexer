#!/bin/bash

OPTS="-jar"
JARPATH="./target/FileIndexer-1.0-SNAPSHOT.jar"

java $OPTS $JARPATH "$@"
