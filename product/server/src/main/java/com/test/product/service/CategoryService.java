package com.test.product.service;

import com.test.product.dataobject.ProductCategory;

import java.util.List;

/**
 * 类目
 *
 * @Auther: zjc
 * @Date: 2019/4/23 10:31
 * @Description:
 */
public interface CategoryService {

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
