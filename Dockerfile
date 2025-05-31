FROM eclipse-temurin:21-jre-jammy AS runtime_base_with_gui_deps

RUN apt-get update && apt-get install -y --no-install-recommends \
    libx11-6 \
    libxext6 \
    libxrender1 \
    libxtst6 \
    libxi6 \
    libxrandr2 \
    libgtk-3-0 \
    ca-certificates \
    && rm -rf /var/lib/apt/lists/*

# Stage 2: Etapa de construcción (Builder) usando Maven con Java 21
FROM maven:3.9.9-eclipse-temurin-21 AS builder

WORKDIR /app

# Copiar solo pom.xml primero
COPY pom.xml .

# Descargar dependencias usando cache mount persistente
RUN --mount=type=cache,target=/root/.m2 \
    mvn dependency:go-offline -B --fail-never

# Copiar código fuente
COPY src ./src

# Compilar usando cache mount
RUN --mount=type=cache,target=/root/.m2 \
    mvn package -B -DskipTests && \
    find target -maxdepth 1 -type f -name "ReInventoryxV2*.jar" -exec mv {} target/app-main.jar \;

FROM runtime_base_with_gui_deps AS runtime

WORKDIR /app

COPY --from=builder /app/target/app-main.jar ./app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
