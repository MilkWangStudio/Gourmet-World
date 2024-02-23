FROM maven:3.9-eclipse-temurin-8 as build
WORKDIR /app
COPY pom.xml .
COPY src ./src
# 打包应用，跳过单元测试
RUN mvn clean package -DskipTests

# 第二阶段：运行应用
FROM openjdk:8-jre-alpine
WORKDIR /app
# 从构建阶段复制构建的jar文件
COPY --from=build /app/target/*.jar app.jar
# 设置时区为上海
ENV TZ=Asia/Shanghai
# 暴露端口
EXPOSE 8080
# 运行jar文件
CMD ["java", "-jar", "app.jar"]