package com.konosuba.rocketmq.email.consumer.service;

import com.konosuba.rocketmq.email.consumer.domain.dto.EmailDto;

/**
 * @author acer
 */
public interface EmailService {

    /**
     * 发送邮件的服务
     * @param emailDto JavaBean
     */
    void sendEmail(EmailDto emailDto) throws Exception;
}
