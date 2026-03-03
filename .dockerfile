# --------- Etapa 1: Build ---------
FROM maven:3.9.6-eclipse-temurin-17 AS build

WORKDIR /app

# Copia pom.xml primeiro (cache de dependências)
COPY pom.xml .
RUN mvn dependency:go-offline

# Copia o restante do projeto
COPY src ./src

# Gera o .jar
RUN mvn clean package -DskipTests

# --------- Etapa 2: Runtime ---------
FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

# Copia o jar gerado da etapa anterior
COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]