package com.konosuba.rocketmq.email.provider.domain.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 存放收件者的邮箱地址
 * @author konosuba
 */
@Data
public class MemberDto implements Serializable {
    private String email;
}
