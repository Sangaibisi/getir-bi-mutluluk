FROM openjdk:11-jre-slim
MAINTAINER emrullah.yildirim
ADD RootBackend/target/getir-spring-boot-exec.jar getir-spring-boot.jar
EXPOSE 5000
ENTRYPOINT ["java","-jar","/getir-spring-boot.jar"]
CMD ["java", "-jar"]