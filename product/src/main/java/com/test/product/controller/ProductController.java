package com.test.product.controller;

import com.test.product.VO.ProductInfoVO;
import com.test.product.VO.ProductVO;
import com.test.product.VO.ResultVO;
import com.test.product.dataobject.ProductCategory;
import com.test.product.dataobject.ProductInfo;
import com.test.product.service.CategoryService;
import com.test.product.service.ProductService;
import com.test.product.utils.ResultVOUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Action;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Auther: zjc
 * @Date: 2019/4/22 14:51
 * @Description:
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    /**
     * 1、查询所有在架的商品
     * 2、获取类目type列表
     * 3、查询类目
     * 4、构造数据
     */
    @GetMapping("/list")
    public ResultVO<ProductVO> list() {

        //查询所有在架的商品
        List<ProductInfo> productInfoList = productService.findUpAll();

        //获取类目type列表
        List<Integer> categoryTypeList = productInfoList.stream()
                .map(ProductInfo::getCategoryType)
                .collect(Collectors.toList());
        //查询类目
        List<ProductCategory> categoryList = categoryService.findByCategoryTypeIn(categoryTypeList);

        //构造数据
        List<ProductVO> productVOList = new ArrayList<>();

        for (ProductCategory productCategory : categoryList) {
            ProductVO productVO = new ProductVO();
            productVO.setCategoryName(productCategory.getCategoryName());
            productVO.setCategoryType(productCategory.getCategoryType().toString());

            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for (ProductInfo productInfo : productInfoList) {

                if (productCategory.getCategoryType() == productInfo.getCategoryType()) {
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo, productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }

            }

            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);
        }

        return ResultVOUtil.success(productVOList);
    }

    /**
     * 功能描述:获取商品列表（给订单服务用的）
     *
     * @auther: zjc
     * @date: 2019/5/30 11:26
     * @param: [productIdList]
     * @return: java.util.List<com.test.product.dataobject.ProductInfo>
     */
    @PostMapping("/listForOrder")//没有参数的时候可以用get，有参数时只能用post
    public List<ProductInfo> listForOrder(@RequestBody List<String> productIdList) {

        return productService.findList(productIdList);
    }
}
