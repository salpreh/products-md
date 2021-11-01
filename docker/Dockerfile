FROM openjdk:11-jre

WORKDIR /opt/app
ADD target/app.jar /opt/app/app.jar

VOLUME /tmp
USER 1000

ENV JAVA_OPTS="-noverify -XX:TieredStopAtLevel=1"

ENTRYPOINT ["/bin/sh", "-c", "java ${JAVA_OPTS} -jar /opt/app/app.jar"]
