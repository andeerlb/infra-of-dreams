FROM openjdk:11.0.11-jre
WORKDIR /app
ARG JAR_VERSION=0.0.1-SNAPSHOT
ARG SPRING_PROFILE_ACTIVE=dev

ENV JAR_VERSION=$JAR_VERSION \
    SPRING_PROFILE_ACTIVE=$SPRING_PROFILE_ACTIVE \
    JAVA_OPTS=""

COPY docker/entrypoint.sh /app/entrypoint.sh
COPY target/demo-$JAR_VERSION.jar /app/demo-$JAR_VERSION.jar

ENTRYPOINT ["/app/entrypoint.sh"]