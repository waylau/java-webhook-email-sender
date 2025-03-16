# Java Webhook Email Sender. 

`Java Webhook Email Sender`实现将Webhook通知通过邮件转发。

有许多服务（如 Apache SkyWalking）仅支持 Webhook 通知，不支持设置邮箱（SMTP）服务进行通知。本项目用于将Webhook转换成邮箱通知。

## Feature 特点

* 接收 POST 请求作为 Webhook 触发器
* 允许发送纯文本或 HTML 格式的电子邮件
* 配置灵活，支持多种 SMTP 服务器
* 异步处理，提高性能和响应速度（todo）
* 轻量，占用内存/存储低
* 支持 Docker 部署

## Usage 使用方法


### 启动 `Java Webhook Email Sender`

Java 原生启动方式：

```
java -jar javawebhookemailsender-1.0.0.jar --spring.mail.username=your@gmail.com --spring.mail.password=your_password
```

其中，启动参数`your@gmail.com`、`your_password`改为你实际的发送者邮箱及密码。`spring.mail.username`和`spring.mail.password`也可以在项目的 application.properties 中进行配置。


Docker 启动方式：


```
docker build --build-arg MAIL_USERNAME=your@gmail.com --build-arg MAIL_PASSWORD=your_password  java-webhook-email-sender:latest .

docker run -p 8080:8080 -it java-webhook-email-sender:latest
```

### 登录


登录管理员账号。默认使用admidn\123执行登录，可以在 application.properties 中修改账号密码：

```
spring.security.user.name=admin
spring.security.user.password=123
```

### 添加收件人


浏览器访问<http://localhost:8080/recipients>添加收件人。

### 配置 SkyWalking 网络钩子

打开 SkyWalking 安装目录下的conﬁg文件夹下 alarm-settings.yml文件，找到 webhooks 这个配置项，进行修改

```
webhooks:
- http://localhost:8080/webhook/skywalking
```

上述 `localhost:8080` 改为你实际的部署地址。


## 持久化

目前默认使用的H2内存数据库，应用重启后数据丢失。可以在 application.properties 中进行配置持久化的数据库，比如 MySQL、PostgreSQL 等。



## Issue 意见、建议

如有勘误、意见或建议欢迎拍砖 <https://github.com/waylau/java-webhook-email-sender/issues>

## Contact 联系作者

* Blog: [waylau.com](http://waylau.com)
* Gmail: [waylau521(at)gmail.com](mailto:waylau521@gmail.com)
* Weibo: [waylau521](http://weibo.com/waylau521)
* Twitter: [waylau521](https://twitter.com/waylau521)
* Github : [waylau](https://github.com/waylau)


## Support Me 请老卫喝一杯

![开源捐赠](https://waylau.com/images/showmethemoney-sm.jpg)
