package com.test.product.service.impl;

import com.test.product.ProductApplicationTests;
import com.test.product.dataobject.ProductCategory;
import com.test.product.service.CategoryService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Auther: zjc
 * @Date: 2019/4/23 10:34
 * @Description:
 */
@Component
public class CategoryServiceImplTest extends ProductApplicationTests {

    @Autowired
    private CategoryService categoryService;

    @Test
    public void findByCategoryTypeIn() {

        List<ProductCategory> categories = categoryService.findByCategoryTypeIn(Arrays.asList(11, 22));


        System.out.println(categories.size());
    }
}