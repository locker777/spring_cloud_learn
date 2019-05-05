package com.test.order.repository;

import com.test.order.dataobject.OrderMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Auther: zjc
 * @Date: 2019/4/29 10:08
 * @Description:
 */
public interface OrderMasterRepository extends JpaRepository<OrderMaster, String> {
}
