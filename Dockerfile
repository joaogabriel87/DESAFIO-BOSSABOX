# Usa uma imagem que já inclui Maven e OpenJDK 21
FROM maven:3.9.6-eclipse-temurin-21 AS builder

# Define o diretório de trabalho
WORKDIR /app

# Copia apenas o pom.xml para cache de dependências
COPY pom.xml .
RUN mvn dependency:go-offline

# Copia o restante do código e compila a aplicação
COPY src ./src
RUN mvn clean package -DskipTests

# Usa uma imagem menor para rodar a aplicação
FROM openjdk:21-jdk-slim

WORKDIR /app
COPY --from=builder /app/target/*.jar app.jar

# Melhor prática: usar JSON no CMD para evitar problemas de sinais no Linux
CMD ["java", "-jar", "app.jar"]
