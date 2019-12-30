package com.test.order.service;

import com.test.order.dto.OrderDTO;

/**
 * @Auther: zjc
 * @Date: 2019/4/29 13:44
 * @Description:
 */

public interface OrderService {

    /**
     * 创建订单
     *
     * @param orderDTO
     * @return
     */
    OrderDTO create(OrderDTO orderDTO);

    /**
     * 完结订单(只能卖家来操作)
     *
     * @param orderId
     * @return
     */
    OrderDTO finish(String orderId);
}
