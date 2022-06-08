package com.gas.management.server.repository;

import com.gas.management.server.entity.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRespository extends CrudRepository<Order, Long> {
    List<Order> findByUserId(long id);
    List<Order> findByShopId(long id);
}
