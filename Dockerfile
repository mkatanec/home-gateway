FROM openjdk:21
COPY build/libs/home-gateway-0.0.1-SNAPSHOT.jar home-gateway-0.0.1.jar
ENTRYPOINT ["java","-jar","/home-gateway-0.0.1.jar"]