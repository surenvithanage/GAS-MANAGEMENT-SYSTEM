package com.gas.management.server.service.auth;

import com.gas.management.server.dto.LoginDto;
import com.gas.management.server.dto.UserDto;
import com.gas.management.server.entity.Role;
import com.gas.management.server.entity.User;
import com.gas.management.server.repository.RoleRepository;
import com.gas.management.server.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.Optional;

@Service
@Transactional
public class AuthenticateServiceImpl implements AuthenticateService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public User login(LoginDto loginDto) {
        User user;
        Optional<User> optionalUser = userRepository.findByUsername(loginDto.getUsername());
        if (optionalUser.isPresent()) {
            user = optionalUser.get();
            if (user.getPassword().equals(loginDto.getPassword())) {
                return user;
            } else {
                return null;
            }
        }
        return null;
    }

    @Override
    public User register(UserDto userDto) {
        User user = new User();
        Optional<Role> optionalRole = roleRepository.findById(Integer.valueOf(userDto.getRoleId()));
        if (optionalRole.isPresent()) {
            user.setAddress(userDto.getAddress());
            user.setEmail(userDto.getEmail());
            user.setFirstName(userDto.getFirstName());
            user.setLastName(userDto.getLastName());
            user.setNic(userDto.getNic());
            user.setPassword(userDto.getPassword());
            user.setPhone(userDto.getPhone());
            user.setUsername(userDto.getUsername());
            user.setRoles(Collections.singleton(optionalRole.get()));
            return userRepository.save(user);
        }
        return null;
    }
}
