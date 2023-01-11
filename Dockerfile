FROM gradle:7.6.0-jdk11-alpine AS build
LABEL test_runner=gradle
WORKDIR /home/gradle/src
COPY --chown=gradle:gradle . .
RUN gradle test --no-daemon -Djavax.net.ssl.trustStore=$JAVA_HOME/lib/security/cacerts -Djavax.net.ssl.trustStorePassword=changeit
