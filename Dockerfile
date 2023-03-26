FROM gradle:7.6.0-jdk11-alpine

# copy the project files into the container
COPY . /app

RUN ls /app
RUN ping "https://central.maven.org/"
# navigate to the project directory
WORKDIR /app