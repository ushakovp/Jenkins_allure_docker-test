FROM gradle:7.6.0-jdk11-alpine

# copy the project files into the container
COPY . /app

RUN ls /app
# navigate to the project directory
WORKDIR /app