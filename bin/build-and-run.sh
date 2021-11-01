#!/bin/bash

echo "> Building project"
# First we build the project
docker run --rm -it -w /code -v "$(pwd):/code" -v "$HOME/.m2:/var/maven/.m2" -e MAVEN_CONFIG=/var/maven/.m2 maven:3.6-jdk-11 mvn -Duser.home=/var/maven clean package

echo "> Build finished"
echo "> Starting containers"

# And now let's start project + infra
docker-compose up --build -d

echo "> Project running"

if command -v curl &> /dev/null; then
    sleep 3
    mkdir -p ./api-doc
    doc_path="./api-doc/api-docs.yml"
    curl http://localhost:8080/v3/api-docs.yaml --output "$doc_path"
    echo "> Openapi spec in folder $(pwd -P)$doc_path"
fi