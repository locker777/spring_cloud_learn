package com.test.order.message;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 接受mq消息
 *
 * @Auther: zjc
 * @Date: 2019/12/9 17:20
 * @Description:
 */
@Slf4j
@Component
public class MqRecevier {

//   1. @RabbitListener(queues = "myQueues")
//   2.自动创建队列 @RabbitListener(queuesToDeclare =@Queue("myQueues"))
//   3.自动创建 Exchange和Queue绑定


    @RabbitListener(bindings = @QueueBinding(
            value = @Queue("myQueues"),
            exchange = @Exchange("myExchange")
    ))
    public void process(String messgae) {
        log.info("MqReceiver : {}", messgae);
    }

    /**
     * 数码供应商服务 接收消息
     *
     * @param messgae
     */
    @RabbitListener(bindings = @QueueBinding(
            exchange = @Exchange("myOrder"),
            key = "computer",
            value = @Queue("computerOrder")
    ))
    public void processComputer(String messgae) {
        log.info("computer MqReceiver : {}", messgae);
    }

    /**
     * 水果供应商服务 接收消息
     *
     * @param messgae
     */
    @RabbitListener(bindings = @QueueBinding(
            exchange = @Exchange("myOrder"),
            key = "fruit",
            value = @Queue("fruitOrder")
    ))
    public void processFruit(String messgae) {
        log.info("fruit MqReceiver : {}", messgae);
    }
}
