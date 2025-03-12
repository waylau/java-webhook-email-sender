# 基础镜像
FROM 192.168.1.78:8084/library/openjdk:17

# 重命名jar包
COPY target/javawebhookemailsender-1.0.0.jar app.jar

# 外部传入的参数
ARG MAIL_USERNAME
ARG MAIL_PASSWORD

# 设置 TZ 时区
# 设置 JAVA_OPTS 环境变量，可通过 docker run -e "JAVA_OPTS=" 或者 k8s 进行覆盖
ENV TZ=Asia/Shanghai JAVA_OPTS="--spring.mail.username=${MAIL_USERNAME} --spring.mail.password=${MAIL_PASSWORD}"

# 声明需要暴露的端口
EXPOSE 8080

# 容器启动后默认的命令或参数，可以被docker run命令后面的参数覆盖
ENTRYPOINT exec java -jar app.jar ${JAVA_OPTS}

