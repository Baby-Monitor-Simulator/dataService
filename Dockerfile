# ---------- Build stage ----------
FROM maven:4.0.0-rc-4 as builder
WORKDIR /workspace

# copy only dependency descriptors first for build cache
COPY pom.xml mvnw* ./
COPY .mvn .mvn
RUN mvn -B -ntp -DskipTests dependency:go-offline

# copy source and build
COPY src ./src
RUN mvn -B -ntp -DskipTests package spring-boot:repackage

# ---------- Runtime stage ----------
# Use a small JRE base for runtime
FROM eclipse-temurin:17-jre-alpine
ARG APP_HOME=/app
WORKDIR ${APP_HOME}

# create non-root user
RUN addgroup -S appgroup && adduser -S appuser -G appgroup

# copy jar from builder
# adjust the JAR name pattern to match your artifact, or keep the last-built jar
COPY --from=builder /workspace/target/*.jar app.jar

# make sure permissions are correct
RUN chown appuser:appgroup app.jar
USER appuser

# expose the port your Spring Boot app uses (default 8080)
EXPOSE 8080

# JVM options can be supplied via environment or override entrypoint
ENV JAVA_OPTS="-Xms128m -Xmx512m -Djava.security.egd=file:/dev/./urandom"

ENTRYPOINT ["sh", "-c", "exec java $JAVA_OPTS -jar /app/app.jar"]
