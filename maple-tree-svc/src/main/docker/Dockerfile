FROM openjdk:8-jdk


EXPOSE 8280

ENV WORK_PATH /home/apps/@project.artifactId@
ENV APP_NAME @project.build.finalName@.@project.packaging@
ENV JAVA_SERVER_OPTS -Djava.security.egd=file:/dev/./urandom -server
ENV ENVPROF dev

WORKDIR /home/apps
COPY $APP_NAME $WORK_PATH/

WORKDIR $WORK_PATH
ENTRYPOINT ["tini", "--"]
CMD java $JAVA_SERVER_OPTS $JAVA_OPTS ${JAVA_OPTS_EXTEND}  -Dskywalking.agent.service_name=@project.artifactId@ -Dskywalking.collector.backend_service=${SW_AGENT_COLLECTOR_BACKEND_SERVICES} -Dskywalking.agent.is_cache_enhanced_class=true -Dskywalking.agent.class_cache_mode=MEMORY -jar $APP_NAME --spring.profiles.active=${ENVPROF}
