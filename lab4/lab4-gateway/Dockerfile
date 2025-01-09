FROM eclipse-temurin:17.0.6_10-jre

LABEL org.opencontainers.image.title="lab6-gateway"
LABEL org.opencontainers.image.authors="Jakub Wiśniewski"
LABEL org.opencontainers.image.version="1.0.0-SNAPSHOT"
LABEL org.opencontainers.image.description="AUI lab, gateway module."
LABEL org.opencontainers.image.licenses="MIT"

LABEL build_version=""
LABEL maintainer=""

ENV VERSION="1.0.0-SNAPSHOT"

ENV SERVER_PORT=8080

ENV SPRING_DATASOURCE_URL=jdbc:h2:mem:testdb
ENV SPRING_DATASOURCE_DRIVERCLASSNAME=org.h2.Driver
ENV SPRING_DATASOURCE_USERNAME=sa
ENV SPRING_DATASOURCE_PASSWORD=''

ENV SPRING_JPA_DATABASE_PLATFORM=org.hibernate.dialect.H2Dialect
ENV SPRING_JPA_GENERATE_DDL=true
ENV SPRING_JPA_HIBERNATE_DDL_AUTO=update

ENV SPRING_H2_CONSOLE_enabled=true

ENV PL_WIESIEK_GATEWAY_HOST=localhost:8080
ENV PL_WIESIEK_DRIVERS_URL=http://localhost:8081
ENV PL_WIESIEK_F1TEAMS_URL=http://localhost:8082

EXPOSE 8080

COPY target/lab4-gateway-${VERSION}.jar /opt/lab4-gateway/lab4-gateway.jar

CMD ["java", "-jar", "/opt/lab4-gateway/lab4-gateway.jar"]

