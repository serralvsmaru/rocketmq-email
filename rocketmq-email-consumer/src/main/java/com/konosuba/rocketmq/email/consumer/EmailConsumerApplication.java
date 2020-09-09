package com.konosuba.rocketmq.email.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Sink;

/**
 * 消费者启动类
 *
 * @author konosuba
 */

@SpringBootApplication(scanBasePackages = {"com.konosuba.redis.provider", "com.konosuba.rocketmq.email.consumer"})
@EnableBinding(Sink.class)
public class EmailConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(EmailConsumerApplication.class, args);
    }
}
