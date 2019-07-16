package com.test.order.service.impl;

import com.test.order.dataobject.OrderDetail;
import com.test.order.dataobject.OrderMaster;
import com.test.order.dataobject.ProductInfo;
import com.test.order.dto.CartDTO;
import com.test.order.dto.OrderDTO;
import com.test.order.enums.OrderStatusEnums;
import com.test.order.enums.PayStatusEnums;
import com.test.order.repository.OrderDetailRepository;
import com.test.order.repository.OrderMasterRepository;
import com.test.order.service.OrderService;
import com.test.order.utils.KeyUtil;
import com.test.product.client.ProductClient;
import com.test.product.common.DecreaseStockInput;
import com.test.product.common.ProductInfoOutput;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Auther: zjc
 * @Date: 2019/4/29 13:53
 * @Description:
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private OrderMasterRepository orderMasterRepository;

    @Autowired
    private ProductClient productClient;

    @Override
    public OrderDTO create(OrderDTO orderDTO) {

        String orderId = KeyUtil.genUniqueKey();
        //  查询商品信息（调用商品服务）
        List<String> productIdList = orderDTO.getOrderDetailList().stream().
                map(OrderDetail::getProductId).collect(Collectors.toList());
        List<ProductInfoOutput> productInfoList = productClient.listForOrder(productIdList);
        //  计算总价
        BigDecimal orderAmount = new BigDecimal(BigInteger.ZERO);
        for (OrderDetail orderDetail : orderDTO.getOrderDetailList()) {
            for (ProductInfoOutput productInfoOutput : productInfoList) {
                if (productInfoOutput.getProductId().equals(orderDetail.getProductId())) {
                    orderAmount = productInfoOutput.getProductPrice().multiply(new BigDecimal(orderDetail.getProductQuantity()))
                            .add(orderAmount);
                    //单价*数量
                    BeanUtils.copyProperties(productInfoOutput, orderDetail);
                    orderDetail.setOrderId(orderId);
                    orderDetail.setDetailId(KeyUtil.genUniqueKey());
                    //订单详情入库
                    orderDetailRepository.save(orderDetail);
                }

            }

        }

        //  扣库存（调用商品服务）
        List<DecreaseStockInput> cartDTOList = orderDTO.getOrderDetailList().stream().
                map(e -> new DecreaseStockInput(e.getProductId(), e.getProductQuantity()))
                .collect(Collectors.toList());
        productClient.decreaseStock(cartDTOList);

        // 订单入库
        OrderMaster orderMaster = new OrderMaster();
        orderDTO.setOrderId(orderId);
        BeanUtils.copyProperties(orderDTO, orderMaster);
        orderMaster.setOrderAmount(new BigDecimal(5));
        orderMaster.setOrderStatus(OrderStatusEnums.NEW.getCode());
        orderMaster.setPayStatus(PayStatusEnums.WAIT.getCode());

        orderMasterRepository.save(orderMaster);
        return orderDTO;
    }
}
