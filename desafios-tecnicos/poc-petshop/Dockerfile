FROM openjdk:11
MAINTAINER Bodegami
COPY target/poc-petshop-0.0.1-SNAPSHOT.jar petshop-1.0.0.jar
ENTRYPOINT ["java","-jar","/petshop-1.0.0.jar"]

#FROM openjdk:11
#COPY . /usr/src/myapp
#WORKDIR /usr/src/myapp
#RUN javac PocPetshopApplication.java
#CMD ["java", "PocPetshopApplication"]