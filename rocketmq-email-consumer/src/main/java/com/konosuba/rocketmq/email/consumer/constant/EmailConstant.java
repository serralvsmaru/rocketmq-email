package com.konosuba.rocketmq.email.consumer.constant;

/**
 * 用来封装发送邮件的内容
 *
 * @author konosuba
 */
public class EmailConstant {
    /**
     * 标题
     */
    public static final String EMAIL_SUBJECT = "XX账号--登录保护验证";
    /**
     * 文本
     * public static final String EMAIL_TEXT_1 = "您好！感谢您使用XX服务，您的账号（";
     */
    public static final String EMAIL_TEXT_1 = "<h3>亲爱的用户：</h3>您好！感谢您使用XX服务，您的账号（";
    /**
     * 文本
     * public static final String EMAIL_TEXT_2 = "）正在进行邮箱验证，本次请求的验证码为："
     */
    public static final String EMAIL_TEXT_2 = "）正在进行邮箱验证，本次请求的验证码为：<br><span style=\"color: red\">";
    /**
     * 文本
     * public static final String EMAIL_TEXT_3 = "(为了保障您帐号的安全性，请在15分钟内完成验证。)"
     */
    public static final String EMAIL_TEXT_3 = "</span>&nbsp;<span style=\"color: darkgray\">(为了保障您帐号的安全性，请在15分钟内完成验证。)</span>";
    /**
     * 作者信息
     */
    public static final String EMAIL_FROM = "<br><br><br>xx技术团队<br>";
}
