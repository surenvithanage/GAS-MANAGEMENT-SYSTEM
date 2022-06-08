package com.gas.management.server.service.order;

import com.gas.management.server.dto.OrderDto;
import com.gas.management.server.entity.Order;

import java.util.List;

public interface OrderService {
    Order create(OrderDto orderDto);

    Iterable<Order> list();

    Order find(long id);

    Order update(OrderDto orderDto, long id);

    boolean delete(long id);

    List<Order> userRelated(long id);

    List<Order> shopRelated(long id);
}
