package com.test.order.repository;

import com.test.order.OrderApplicationTests;
import org.junit.Test;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Auther: zjc
 * @Date: 2019/12/9 17:23
 * @Description:
 */
@Component
public class MqSenderTest extends OrderApplicationTests {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Test
    public void send(){

        amqpTemplate.convertAndSend("myQueues","now ="+new Date());
    }

    @Test
    public void sendOrder(){

        amqpTemplate.convertAndSend("myOrder","computer","now ="+new Date());
    }

}
