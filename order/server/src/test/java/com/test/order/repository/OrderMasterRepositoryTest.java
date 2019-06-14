package com.test.order.repository;

import com.test.order.OrderApplicationTests;
import com.test.order.dataobject.OrderMaster;
import com.test.order.enums.OrderStatusEnums;
import com.test.order.enums.PayStatusEnums;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.Table;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @Auther: zjc
 * @Date: 2019/4/29 10:17
 * @Description:
 */
@Component
public class OrderMasterRepositoryTest extends OrderApplicationTests {

    @Autowired
    private OrderMasterRepository orderMasterRepository;

    @Test
    public void testSave() {

        OrderMaster orderMaster = new OrderMaster();

        orderMaster.setOrderId("1234568");
        orderMaster.setBuyerName("张三");
        orderMaster.setBuyerPhone("13800138000");
        orderMaster.setBuyerAddress("朝阳");
        orderMaster.setBuyerOpenid("weixinhao111");
        orderMaster.setOrderAmount(new BigDecimal(2.5));
        orderMaster.setOrderStatus(OrderStatusEnums.NEW.getCode());
        orderMaster.setPayStatus(PayStatusEnums.WAIT.getCode());

        OrderMaster result = orderMasterRepository.save(orderMaster);
        System.out.println("result:" + result);
    }


}