package com.test.product.service.impl;

import com.test.product.common.DecreaseStockInput;
import com.test.product.dataobject.ProductInfo;
import com.test.product.enums.ProductStatusEnum;
import com.test.product.enums.ResultEnum;
import com.test.product.exception.ProductException;
import com.test.product.repository.ProductInfoRepository;
import com.test.product.service.ProductService;
import com.test.product.utils.JsonUtil;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * @Auther: zjc
 * @Date: 2019/4/23 10:18
 * @Description:
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Override
    public List<ProductInfo> findUpAll() {
        return productInfoRepository.findByProductStatus(ProductStatusEnum.UP.getCode());
    }

    @Override
    public List<ProductInfo> findList(List<String> productIdList) {
        return productInfoRepository.findByProductIdIn(productIdList);
    }

    @Override
    @Transactional
    public void decreaseStock(List<DecreaseStockInput> decreaseStockInputList) {
        for (DecreaseStockInput decreaseStockInput: decreaseStockInputList) {
            Optional<ProductInfo> productInfoOptional = productInfoRepository.findById(decreaseStockInput.getProductId());
            //判断商品是否存在
            if (!productInfoOptional.isPresent()) {
                throw new ProductException(ResultEnum.PRODUCT_NOT_EXIST);
            }

            ProductInfo productInfo = productInfoOptional.get();
            //库存是否足够
            int result = productInfo.getProductStock() - decreaseStockInput.getProductQuantity();
            if (result < 0) {
                throw new ProductException(ResultEnum.PRODUCT_STOCK_ERROE);
            }
            productInfo.setProductStock(result);
            productInfoRepository.save(productInfo);

            //发送mq消息
            amqpTemplate.convertAndSend("productInfo",JsonUtil.toJson(productInfo));
        }
    }
}
