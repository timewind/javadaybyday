## 表示使用 Jdk8 环境 为基础镜像，如果镜像不是本地的会从 DockerHub 进行下载
##FROM openjdk:8-jdk-alpine
## 在宿主机的/var/lib/docker目录下创建一个临时文件并把它链接到容器中的/tmp目录
##VOLUME /tmp
##ADD programming-0.0.1-SNAPSHOT.jar app.jar
##ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]



#指定基础镜像，在其上进行定制
FROM java:8

#维护者信息
MAINTAINER nivelle

#这里的 /tmp 目录就会在运行时自动挂载为匿名卷，任何向 /tmp 中写入的信息都不会记录进容器存储层
VOLUME /tmp

#复制上下文目录下的target/demo-1.0.0.jar 到容器里
COPY target/javaguide-1.0.0.jar javaguide-1.0.0.jar

#bash方式执行，使javaguide-0.0.1.jar可访问
#RUN新建立一层，在其上执行这些命令，执行结束后， commit 这一层的修改，构成新的镜像。
RUN bash -c "touch /javaguide-1.0.0.jar"

#声明运行时容器提供服务端口，这只是一个声明，在运行时并不会因为这个声明应用就会开启这个端口的服务
EXPOSE 8088

#指定容器启动程序及参数   <ENTRYPOINT> "<CMD>"
ENTRYPOINT ["java","-jar","javaguide-1.0.0.jar"]