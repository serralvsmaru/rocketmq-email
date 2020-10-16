package com.konosuba.rocketmq.email.provider.controller;

import com.konosuba.rocketmq.email.provider.domain.dto.MemberDto;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author konosuba
 */
@RestController
@RequestMapping("/provider")
public class EmailController {
    @Resource(name = "output")
    private MessageChannel messageChannel;

    @PostMapping("/eamil")
    public boolean email(@RequestBody MemberDto memberDto){
        boolean send = messageChannel.send(MessageBuilder.withPayload(memberDto)..setHeader(MessageConst.PROPERTY_TAGS, "tagStr")build());
        return send;
    }
}
