package com.gas.management.server.controller;

import com.gas.management.server.dto.ErrorDto;
import com.gas.management.server.dto.UserDto;
import com.gas.management.server.entity.User;
import com.gas.management.server.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity create(@RequestBody UserDto userDto) {
        User user = userService.create(userDto);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            ErrorDto errorDto = new ErrorDto();
            errorDto.setErrorCode("E002");
            errorDto.setErrorMessage("Error occurred while processing");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorDto);
        }
    }

    @GetMapping
    public ResponseEntity list() {
        List<User> userList = (List<User>) userService.list();
        return ResponseEntity.ok(userList);
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@RequestBody UserDto userDto, @PathVariable String id) {
        User user = userService.update(userDto, Long.parseLong(id));
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            ErrorDto errorDto = new ErrorDto();
            errorDto.setErrorCode("E002");
            errorDto.setErrorMessage("Error occurred while processing");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorDto);
        }
    }

    @GetMapping("/find/{id}")
    public ResponseEntity find(@PathVariable String id) {
        User user = userService.find(Long.parseLong(id));
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            ErrorDto errorDto = new ErrorDto();
            errorDto.setErrorCode("E002");
            errorDto.setErrorMessage("Error occurred while processing");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorDto);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable String id) {
        boolean result = userService.delete(Long.parseLong(id));
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
