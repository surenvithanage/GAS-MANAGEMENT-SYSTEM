package com.gas.management.server.service.shop;

import com.gas.management.server.dto.ShopDto;
import com.gas.management.server.entity.Shop;

public interface ShopService {
    Shop create(ShopDto shopDto);

    Iterable<Shop> list();

    Shop find(long id);

    Shop update(ShopDto shopDto, long id);

    boolean delete(long id);
}
