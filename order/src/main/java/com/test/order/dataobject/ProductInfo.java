package com.test.order.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @Auther: zjc
 * @Date: 2019/4/22 15:09
 * @Description:
 */
@Table(name = "product_info")//一般 大小写 下划线没有问题 可以自己匹配到
@Data
@Entity
public class ProductInfo {

    @Id
    private String productId;

    private String productName;
    private BigDecimal productPrice;
    private Integer productStock;
    private String productDescription;
    private String productIcon;
    private Integer productStatus;
    private Integer categoryType;
    private Date createTime;
    private Date updateTime;

}
