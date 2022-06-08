package com.gas.management.server.controller;

import com.gas.management.server.dto.ErrorDto;
import com.gas.management.server.dto.LoginDto;
import com.gas.management.server.dto.UserDto;
import com.gas.management.server.entity.User;
import com.gas.management.server.service.auth.AuthenticateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticateService authenticateService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginDto loginDto) {
        User user = authenticateService.login(loginDto);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            ErrorDto errorDto = new ErrorDto();
            errorDto.setErrorCode("E001");
            errorDto.setErrorMessage("Invalid Credentials");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorDto);
        }
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody UserDto userDto) {
        User user = authenticateService.register(userDto);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            ErrorDto errorDto = new ErrorDto();
            errorDto.setErrorCode("E002");
            errorDto.setErrorMessage("Error occurred while processing");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorDto);
        }
    }

}
