#!/bin/sh

exec java $JAVA_OPTS \
     -Duser.timezone=GMT \
     -Djava.security.egd=file:/dev/./urandom \
     -Dspring.profiles.active=$SPRING_PROFILE_ACTIVE \
     -jar /app/demo-$JAR_VERSION.jar