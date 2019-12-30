package com.test.order.controller;

import com.test.order.dto.OrderDTO;
import com.test.order.message.StreamClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @Auther: zjc
 * @Date: 2019/12/10 14:53
 * @Description:
 */
@RestController
public class SendMessageController {

    @Autowired
    private StreamClient streamClient;

    /**
     * 发送OrderDTO对象
     */
    @GetMapping("/sendMessage")
    public void process() {

        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setOrderId("123456");
        String message = "now " + new Date();
        streamClient.output().send(MessageBuilder.withPayload(orderDTO).build());
    }

}
