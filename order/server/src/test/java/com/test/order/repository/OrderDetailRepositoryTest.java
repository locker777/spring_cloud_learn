package com.test.order.repository;

import com.test.order.OrderApplicationTests;
import com.test.order.dataobject.OrderDetail;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @Auther: zjc
 * @Date: 2019/4/29 10:48
 * @Description:
 */
@Component
public class OrderDetailRepositoryTest extends OrderApplicationTests {

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Test
    public void testSave() {

        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("1234567");
        orderDetail.setOrderId("123456");
        orderDetail.setProductIcon("http://");
        orderDetail.setProductName("皮蛋粥");
        orderDetail.setProductId("157875196366160022");
        orderDetail.setProductPrice(new BigDecimal(0.01));
        orderDetail.setProductQuantity(2);

        OrderDetail result = orderDetailRepository.save(orderDetail);

        System.out.println(result);
    }

}