package com.gas.management.server.controller;

import com.gas.management.server.dto.ErrorDto;
import com.gas.management.server.dto.OrderDto;
import com.gas.management.server.entity.Order;
import com.gas.management.server.service.order.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity create(@RequestBody OrderDto orderDto) {
        Order order = orderService.create(orderDto);
        if (order != null) {
            return ResponseEntity.ok(order);
        } else {
            ErrorDto errorDto = new ErrorDto();
            errorDto.setErrorCode("E002");
            errorDto.setErrorMessage("Error occurred while processing");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorDto);
        }
    }

    @GetMapping
    public ResponseEntity list() {
        List<Order> orderList = (List<Order>) orderService.list();
            return ResponseEntity.ok(orderList);
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@RequestBody OrderDto shopDto, @PathVariable String id) {
        Order order = orderService.update(shopDto, Long.parseLong(id));
        if (order != null) {
            return ResponseEntity.ok(order);
        } else {
            ErrorDto errorDto = new ErrorDto();
            errorDto.setErrorCode("E002");
            errorDto.setErrorMessage("Error occurred while processing");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorDto);
        }
    }

    @GetMapping("/find/{id}")
    public ResponseEntity find(@PathVariable String id) {
        Order order = orderService.find(Long.parseLong(id));
        if (order != null) {
            return ResponseEntity.ok(order);
        } else {
            ErrorDto errorDto = new ErrorDto();
            errorDto.setErrorCode("E002");
            errorDto.setErrorMessage("Error occurred while processing");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorDto);
        }
    }

    @GetMapping("/find/user/{id}")
    public ResponseEntity findByUser(@PathVariable String id) {
        List<Order> order = orderService.userRelated(Long.parseLong(id));
        if (order != null) {
            return ResponseEntity.ok(order);
        } else {
            ErrorDto errorDto = new ErrorDto();
            errorDto.setErrorCode("E002");
            errorDto.setErrorMessage("Error occurred while processing");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorDto);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable String id) {
        boolean result = orderService.delete(Long.parseLong(id));
        if (result) {
            return ResponseEntity.ok(result);
        } else {
            ErrorDto errorDto = new ErrorDto();
            errorDto.setErrorCode("E002");
            errorDto.setErrorMessage("Error occurred while processing");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorDto);
        }
    }
}