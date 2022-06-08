package com.gas.management.server.controller;

import com.gas.management.server.dto.ErrorDto;
import com.gas.management.server.dto.StockDto;
import com.gas.management.server.entity.Stock;
import com.gas.management.server.service.stock.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/stock")
public class StockController {

    @Autowired
    private StockService stockService;

    @PostMapping
    public ResponseEntity create(@RequestBody StockDto stockDto) {
        Stock shop = stockService.create(stockDto);
        if (shop != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(shop);
        } else {
            ErrorDto errorDto = new ErrorDto();
            errorDto.setErrorCode("E002");
            errorDto.setErrorMessage("Error occurred while processing");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorDto);
        }
    }

    @GetMapping
    public ResponseEntity list() {
        List<Stock> stockList = (List<Stock>) stockService.list();
            return ResponseEntity.ok(stockList);

    }

    @PutMapping("/{id}")
    public ResponseEntity update(@RequestBody StockDto stockDto, @PathVariable String id) {
        Stock shop = stockService.update(stockDto, Long.parseLong(id));
        if (shop != null) {
            return ResponseEntity.status(HttpStatus.OK).body(shop);
        } else {
            ErrorDto errorDto = new ErrorDto();
            errorDto.setErrorCode("E002");
            errorDto.setErrorMessage("Error occurred while processing");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorDto);
        }
    }

    @GetMapping("/find/{id}")
    public ResponseEntity find(@PathVariable String id) {
        Stock stock = stockService.find(Long.parseLong(id));
        if (stock != null) {
            return ResponseEntity.status(HttpStatus.OK).body(stock);
        } else {
            ErrorDto errorDto = new ErrorDto();
            errorDto.setErrorCode("E002");
            errorDto.setErrorMessage("Error occurred while processing");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorDto);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable String id) {
        boolean result = stockService.delete(Long.parseLong(id));
        if (result) {
            return ResponseEntity.status(HttpStatus.OK).body(result);
        } else {
            ErrorDto errorDto = new ErrorDto();
            errorDto.setErrorCode("E002");
            errorDto.setErrorMessage("Error occurred while processing");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorDto);
        }
    }
}
