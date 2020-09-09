package com.konosuba.rocketmq.email.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;

/**
 * @author konosuba
 */
@SpringBootApplication
@EnableBinding(Source.class)
public class EmailProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(EmailProviderApplication.class, args);
    }
}
