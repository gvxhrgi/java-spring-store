package com.example.demo.mappers;

import com.example.demo.models.products.ProductEntity;
import com.example.demo.models.products.ProductRequest;
import com.example.demo.models.products.ProductResponse;
import com.example.demo.models.user.UserEntity;
import com.example.demo.models.user.UserRequest;
import com.example.demo.models.user.UserResponse;

public class UserMapper {
    public static UserEntity mapRequestToEntity(UserRequest userRequest) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUserName(userRequest.getUserName());
        userEntity.setName(userEntity.getName());
        return userEntity;
    }

    public static UserResponse mapEntityToResponse(UserEntity userEntity) {
        UserResponse userResponse = new UserResponse();
        userResponse.setId(userEntity.getId());
        userResponse.setName(userEntity.getName());
        userResponse.setUserName(userEntity.getUserName());
        return userResponse;
    }
}
