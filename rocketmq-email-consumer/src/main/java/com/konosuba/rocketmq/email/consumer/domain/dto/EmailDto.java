package com.konosuba.rocketmq.email.consumer.domain.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 接受生产者提供的收件者邮箱
 *
 * @author konosuba
 */
@Data
public class EmailDto implements Serializable {

    private String email;
}
