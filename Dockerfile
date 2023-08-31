FROM amazoncorretto:17.0.8
LABEL authors="orjanskarnes"
COPY settings.gradle.kts .
COPY gradlew .
RUN mkdir -p gradle/wrapper
COPY gradle/* gradle/wrapper
RUN chmod +x gradlew
COPY app ./app
RUN ./gradlew build
CMD ["./gradlew", "run"]