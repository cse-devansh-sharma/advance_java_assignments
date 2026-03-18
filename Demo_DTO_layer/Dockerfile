FROM openjdk:22-jdk

WORKDIR /app

ADD target/rest-demo.jar.jar /app/rest-demo.jar.jar

ENTRYPOINT ["java","-jar","/app/rest-demo.jar.jar"]