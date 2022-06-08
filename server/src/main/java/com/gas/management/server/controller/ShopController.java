package com.gas.management.server.controller;

import com.gas.management.server.dto.ErrorDto;
import com.gas.management.server.dto.ShopDto;
import com.gas.management.server.entity.Shop;
import com.gas.management.server.service.shop.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/shop")
public class ShopController {

    @Autowired
    private ShopService shopService;

    @PostMapping
    public ResponseEntity create(@RequestBody ShopDto shopDto) {
        Shop shop = shopService.create(shopDto);
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
        List<Shop> shopList = (List<Shop>) shopService.list();
            return ResponseEntity.ok(shopList);
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@RequestBody ShopDto shopDto, @PathVariable String id) {
        Shop shop = shopService.update(shopDto, Long.parseLong(id));
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
        Shop shop = shopService.find(Long.parseLong(id));
        if (shop != null) {
            return ResponseEntity.status(HttpStatus.OK).body(shop);
        } else {
            ErrorDto errorDto = new ErrorDto();
            errorDto.setErrorCode("E002");
            errorDto.setErrorMessage("Error occurred while processing");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorDto);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable String id) {
        boolean result = shopService.delete(Long.parseLong(id));
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