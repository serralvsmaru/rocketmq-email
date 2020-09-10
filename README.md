## 使用方式
1. 将RocketMQ、Redis的地址改成自己的
2. 记得写consumer里面的application.yml的发件人邮箱和授权码
3. 依次启动email-provider、redis-provider、email-consumer
4. 在Postman用Post请求访问http://127.0.0.1:9091/provider/eamil，发送的请求数据为{"email" : "<收件人邮箱>"}
5. 查看收件人邮箱即可看到邮件
