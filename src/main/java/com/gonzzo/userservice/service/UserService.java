package com.gonzzo.userservice.service;

import org.springframework.stereotype.Service;
import jakarta.validation.Valid;

import com.gonzzo.userservice.repository.UserRepository;
import com.gonzzo.userservice.entity.UserEntity;
import com.gonzzo.userservice.dto.UserRequest;
import com.gonzzo.userservice.dto.UserResponse;

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
                .map(this::mapToResponse)
                .toList();
    }

    public UserResponse createUser(UserRequest request) {
        UserEntity entity = new UserEntity();
        entity.setName(request.getName());
        entity.setEmail(request.getEmail());

        UserEntity saved = userRepository.save(entity);

        return mapToResponse(saved);
    }

    private UserResponse mapToResponse(UserEntity entity) {
        UserResponse response = new UserResponse();
        response.setId(entity.getId());
        response.setName(entity.getName());
        response.setEmail(entity.getEmail());
        return response;
    }

}
