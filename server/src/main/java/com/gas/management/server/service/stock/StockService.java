package com.gas.management.server.service.stock;

import com.gas.management.server.dto.StockDto;
import com.gas.management.server.entity.Stock;

public interface StockService {
    Stock create(StockDto stockDto);

    Iterable<Stock> list();

    Stock find(long id);

    Stock update(StockDto stockDto, long id);

    boolean delete(long id);
}
