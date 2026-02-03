package com.gonzzo.userservice.mapper;

import com.gonzzo.userservice.entity.UserEntity;
import com.gonzzo.userservice.dto.UserResponse;

public class UserMapper {
    public static UserResponse toResponse(UserEntity entity) {
        UserResponse response = new UserResponse(
                entity.getId(),
                entity.getName(),
                entity.getEmail(),
                entity.isActive(),
                entity.getCreatedAt()
        );
        return response;
    }
}
