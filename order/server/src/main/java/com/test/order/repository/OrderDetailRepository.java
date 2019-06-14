package com.test.order.repository;

import com.test.order.dataobject.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @Auther: zjc
 * @Date: 2019/4/29 10:08
 * @Description:
 */
@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail, String> {


}
