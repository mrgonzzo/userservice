package com.gonzzo.userservice.service;

import org.springframework.stereotype.Service;
import jakarta.validation.Valid;

import com.gonzzo.userservice.repository.UserRepository;
import com.gonzzo.userservice.entity.UserEntity;
import com.gonzzo.userservice.dto.UserRequest;
import com.gonzzo.userservice.dto.UserResponse;
import com.gonzzo.userservice.mapper.UserMapper;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {

        this.userRepository = userRepository;
    }

    public List<UserResponse> getUsers() {
        return userRepository.findAll()
                .stream()
                .map(UserMapper::toResponse)
                .toList();
    }

    public UserResponse createUser(UserRequest request) {
        UserEntity entity = new UserEntity();
        entity.setName(request.getName());
        entity.setEmail(request.getEmail());

        UserEntity saved = userRepository.save(entity);

        return UserMapper.toResponse(saved);
    }
}
