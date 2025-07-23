# 🧱 Fase de construção: Maven + JDK 21 já vem na marmita
FROM maven:3.9.5-eclipse-temurin-17 as builder

# 📁 Criando o diretório da aplicação dentro do container
WORKDIR /app

# ⛴️ Copiando o projeto todinho pra dentro do container
COPY . .

# 🏗️ Compilando o projeto e pulando os testes porque tempo é café
RUN mvn clean package -DskipTests

# 🧼 Fase de execução: imagem mais magra que dieta de segunda-feira
FROM eclipse-temurin:17-jre-jammy

# 📁 Criando diretório de trabalho
WORKDIR /app

# 🚚 Copiando o .jar da fase de build
COPY --from=builder /app/target/usuario-api-0.0.1-SNAPSHOT.jar app.jar

# 🚀 Bora subir essa bagaça!
ENTRYPOINT ["java", "-jar", "app.jar"]
