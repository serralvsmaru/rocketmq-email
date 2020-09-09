package com.konosuba.rocketmq.email.consumer.service.impl;

import com.konosuba.redis.provider.service.RedisService;
import com.konosuba.rocketmq.email.consumer.constant.EmailConstant;
import com.konosuba.rocketmq.email.consumer.domain.dto.EmailDto;
import com.konosuba.rocketmq.email.consumer.service.EmailService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.mail.internet.MimeMessage;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * 接口实现类
 * @author konosuba
 */
@Service
public class EmailServiceImpl implements EmailService {
    @Resource
    private RedisService redisService;
    /**
     * 用来发送邮件
     */
    @Resource
    private JavaMailSender javaMailSender;
    @Value("${spring.mail.username}")
    private String username;

//    /**
//     * 发送普通文本
//     * @param emailDto JavaBean
//     * @throws Exception 抛出发送失败的异常
//     */
//    @Override
//    @StreamListener("input")
//    public void sendEmail(EmailDto emailDto) throws Exception {
//        // 发送验证码
//        String verificationCode = "konosuba is the best";
//        // 目标邮箱
//        String email = emailDto.getEmail();
//        // 隐私原因，截取
//        String[] emailSplit = email.split("@");
//        // 判断是否正确的邮箱
//        int length = 2;
//        if (emailSplit.length != length) {
//            throw new Exception("邮箱错误");
//        }
//        // 邮箱的前几位
//        String emailPre = emailSplit[0];
//        // 邮箱加密
//        String privacyEmail = emailPre.substring(0, 2) + "**"
//                + emailPre.substring(emailPre.length() - 1)
//                + "@" + emailSplit[1];
//        // 封装发送信息
//        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
//        // 标题
//        simpleMailMessage.setSubject(EmailConstant.EMAIL_SUBJECT);
//        // 发送人
//        simpleMailMessage.setFrom(username);
//        // 目标邮箱
//        simpleMailMessage.setTo(email);
//        // 发送的文本
//        simpleMailMessage.setText(EmailConstant.EMAIL_TEXT_1
//                + privacyEmail
//                + EmailConstant.EMAIL_TEXT_2
//                + verificationCode
//                + EmailConstant.EMAIL_TEXT_3);
//        // 发送的时间
//        simpleMailMessage.setSentDate(new Date());
//        // 发送信息
//        // try 发送失败不会重试
//        try{
//            javaMailSender.send(simpleMailMessage);
//        }catch (MailException e){
//            e.printStackTrace();
//        }
//        // redis 设置过期时间(单位：秒)
//        int timeout = 15;
//        // 将验证码存储到 redis
//        redisService.set(email, verificationCode, timeout, TimeUnit.MINUTES);
//    }


    /**
     * 发送html文本
     * @param emailDto JavaBean
     * @throws Exception 抛出发送失败的异常
     */
    @Override
    @StreamListener("input")
    public void sendEmail(EmailDto emailDto) throws Exception {
        // 发送验证码
        String verificationCode = "konosuba is the best";
        // 目标邮箱
        String email = emailDto.getEmail();
        // 隐私原因，截取
        String[] emailSplit = email.split("@");
        // 判断是否正确的邮箱
        int length = 2;
        if (emailSplit.length != length) {
            throw new Exception("邮箱错误");
        }
        // 邮箱的前几位
        String emailPre = emailSplit[0];
        // 邮箱加密
        String privacyEmail = emailPre.substring(0, 2) + "**"
                + emailPre.substring(emailPre.length() - 1)
                + "@" + emailSplit[1];
        // 封装发送信息，发送html页面
        MimeMessage mimeMailMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMailMessage, true, "utf-8");
        // 标题
        mimeMessageHelper.setSubject(EmailConstant.EMAIL_SUBJECT);
        // 发送人
        mimeMessageHelper.setFrom(username);
        // 目标邮箱
        mimeMessageHelper.setTo(email);
        // 发送的文本
        mimeMessageHelper.setText(EmailConstant.EMAIL_TEXT_1
                + privacyEmail
                + EmailConstant.EMAIL_TEXT_2
                + verificationCode
                + EmailConstant.EMAIL_TEXT_3
                + EmailConstant.EMAIL_FROM
                + new SimpleDateFormat("yyyy年MM月dd日").format(new Date()), true);
        // 发送的时间
        mimeMessageHelper.setSentDate(new Date());
        // 发送信息
        // try 发送失败不会重试
        try{
            javaMailSender.send(mimeMailMessage);
        }catch (MailException e){
            e.printStackTrace();
        }
        // redis 设置过期时间(单位：秒)
        int timeout = 15;
        // 将验证码存储到 redis
        redisService.set(email, verificationCode, timeout, TimeUnit.MINUTES);
    }
}
