package com.gas.management.server.service.auth;

import com.gas.management.server.dto.LoginDto;
import com.gas.management.server.dto.UserDto;
import com.gas.management.server.entity.User;

public interface AuthenticateService {
    User login(LoginDto loginDto);

    User register(UserDto userDto);
}
