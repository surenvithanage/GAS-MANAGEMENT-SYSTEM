package com.gas.management.server.service.stock;

import com.gas.management.server.dto.StockDto;
import com.gas.management.server.entity.Stock;
import com.gas.management.server.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.Optional;

@Service
@Transactional
public class StockServiceImpl implements StockService {

    @Autowired
    private StockRepository stockRepository;


    @Override
    public Stock create(StockDto stockDto) {
        Stock stock = new Stock();
        try {
            stock.setDate(new Date());
            stock.setQuantity(stockDto.getQuantity());
            stock.setType(stockDto.getType());
            stock.setShopId(stockDto.getShopId());
            return stockRepository.save(stock);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Iterable<Stock> list() {
        return stockRepository.findAll();
    }

    @Override
    public Stock find(long id) {
        Optional<Stock> optionalStock = stockRepository.findById(id);
        if (optionalStock.isPresent()) {
            return optionalStock.get();
        }
        return null;
    }

    @Override
    public Stock update(StockDto stockDto, long id) {
        Stock stock;
        Optional<Stock> optionalStock = stockRepository.findById(id);
        if (optionalStock.isPresent()) {
            stock = optionalStock.get();
            stock.setDate(new Date());
            stock.setQuantity(stockDto.getQuantity());
            stock.setType(stockDto.getType());
            return stockRepository.save(stock);
        }
        return null;
    }

    @Override
    public boolean delete(long id) {
        Optional<Stock> optionalStock = stockRepository.findById(id);
        if (optionalStock.isPresent()) {
            stockRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
