FROM nginx:1.23.3

LABEL org.opencontainers.image.title="lab6-ng"
LABEL org.opencontainers.image.authors="Jakub Wiśniewski"
LABEL org.opencontainers.image.version="1.0.0-SNAPSHOT"
LABEL org.opencontainers.image.description="AUI lab, gateway module."
LABEL org.opencontainers.image.licenses="MIT"

LABEL build_version=""
LABEL maintainer=""

ENV VERSION="1.0.0-SNAPSHOT"

ENV API_URL http://localhost:8080/api

EXPOSE 80

ADD dist/lab5-angular/browser /usr/share/nginx/html/
ADD docker/etc/nginx/templates/ /etc/nginx/templates/

