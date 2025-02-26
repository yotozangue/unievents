FROM tomcat:9.0-jre8

RUN rm -rf /usr/local/tomcat/webapps/*

COPY target/unievents-1.0.0.war /usr/local/tomcat/webapps/ROOT.war

EXPOSE ${SERVER_PORT}

CMD ["catalina.sh", "run"]
