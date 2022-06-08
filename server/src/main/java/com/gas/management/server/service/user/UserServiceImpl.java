package com.gas.management.server.service.user;

import com.gas.management.server.dto.UserDto;
import com.gas.management.server.entity.Role;
import com.gas.management.server.entity.User;
import com.gas.management.server.repository.RoleRepository;
import com.gas.management.server.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public User create(UserDto userDto) {
        User user;
        try {
            Optional<Role> optionalRole = roleRepository.findById(Integer.valueOf(userDto.getRoleId()));
            if (optionalRole.isPresent()) {
                user = new User();
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
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<User> list() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public User find(long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            return optionalUser.get();
        }
        return null;
    }

    @Override
    public User update(UserDto userDto, long id) {
        User user;
        try {
            Optional<User> optionalUser = userRepository.findById(id);
            if (optionalUser.isPresent()) {
                user = optionalUser.get();
                user.setAddress(userDto.getAddress());
                user.setEmail(userDto.getEmail());
                user.setFirstName(userDto.getFirstName());
                user.setLastName(userDto.getLastName());
                user.setNic(userDto.getNic());
                user.setPassword(userDto.getPassword());
                user.setPhone(userDto.getPhone());
                return userRepository.save(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean delete(long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
