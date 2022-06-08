package com.gas.management.server.service.user;

import com.gas.management.server.dto.UserDto;
import com.gas.management.server.entity.User;

public interface UserService {
    User create(UserDto userDto);
    Iterable<User> list();
    User find(long id);
    User update(UserDto userDto, long id);
    boolean delete(long id);
}
