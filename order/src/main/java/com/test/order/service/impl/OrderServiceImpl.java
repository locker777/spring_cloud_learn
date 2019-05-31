package com.test.order.service.impl;

import com.test.order.client.ProductClient;
import com.test.order.dataobject.OrderDetail;
import com.test.order.dataobject.OrderMaster;
import com.test.order.dataobject.ProductInfo;
import com.test.order.dto.OrderDTO;
import com.test.order.enums.OrderStatusEnums;
import com.test.order.enums.PayStatusEnums;
import com.test.order.repository.OrderDetailRepository;
import com.test.order.repository.OrderMasterRepository;
import com.test.order.service.OrderService;
import com.test.order.utils.KeyUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
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

        //  查询商品信息（调用商品服务）
        List<String> productIdList = orderDTO.getOrderDetailList().stream().
                map(OrderDetail::getProductId).collect(Collectors.toList());
        List<ProductInfo> productInfoList = productClient.listForOrder(productIdList);
        //  计算总价
        BigDecimal orderAmount=new BigDecimal(BigDecimal.ZERO);
        for (OrderDetail orderDetail : orderDTO.getOrderDetailList()) {
            for (ProductInfo productInfo: productInfoList) {
                if(productInfo.getProductId().equals(orderDetail.getProductId())){
                    orderDetail.getProductPrice()*
                    //单价*数量
                }
                
            }

        }

        // TODO 扣库存（调用商品服务）


        // 订单入库
        OrderMaster orderMaster = new OrderMaster();
        orderDTO.setOrderId(KeyUtil.genUniqueKey());
        BeanUtils.copyProperties(orderDTO, orderMaster);
        orderMaster.setOrderAmount(new BigDecimal(5));
        orderMaster.setOrderStatus(OrderStatusEnums.NEW.getCode());
        orderMaster.setPayStatus(PayStatusEnums.WAIT.getCode());

        orderMasterRepository.save(orderMaster);
        return orderDTO;
    }
}
