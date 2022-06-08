package com.gas.management.server.service.shop;

import com.gas.management.server.dto.ShopDto;
import com.gas.management.server.entity.Shop;
import com.gas.management.server.repository.ShopRepository;
import com.gas.management.server.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class ShopServiceImpl implements ShopService {

    @Autowired
    private ShopRepository shopRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Shop create(ShopDto shopDto) {
        Shop shop;
        try {
            shop = new Shop();
            shop.setLocation(shopDto.getLocation());
            shop.setName(shopDto.getName());
            shop.setTelephone(shopDto.getTelephone());
            shop.setUserId(Long.parseLong(shopDto.getUserId()));
            shop.setLongitude(shopDto.getLongitude());
            shop.setLatitude(shopDto.getLatitude());
            return shopRepository.save(shop);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Iterable<Shop> list() {
        return shopRepository.findAll();
    }

    @Override
    public Shop find(long id) {
        Optional<Shop> optionalShop = shopRepository.findById(id);
        if (optionalShop.isPresent()) {
            return optionalShop.get();
        }
        return null;
    }

    @Override
    public Shop update(ShopDto shopDto, long id) {
        Shop shop;
        try {
            Optional<Shop> optionalShop = shopRepository.findById(id);
            if (optionalShop.isPresent()) {
                shop = optionalShop.get();
                shop.setLocation(shopDto.getLocation());
                shop.setName(shopDto.getName());
                shop.setLongitude(shopDto.getLongitude());
                shop.setLatitude(shopDto.getLatitude());
                shop.setTelephone(shopDto.getTelephone());
                return shopRepository.save(shop);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean delete(long id) {
        Optional<Shop> optionalShop = shopRepository.findById(id);
        if (optionalShop.isPresent()) {
            shopRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
