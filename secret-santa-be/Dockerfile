FROM amazoncorretto:19.0.1-alpine3.16

COPY ./target/secret-santa-0.0.1-SNAPSHOT.jar /usr/app/

WORKDIR /usr/app

RUN sh -c 'touch secret-santa-0.0.1-SNAPSHOT.jar'

ENTRYPOINT ["java","-jar","secret-santa-0.0.1-SNAPSHOT.jar"]