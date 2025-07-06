package com.example.demo.services;

import com.example.demo.mappers.UserMapper;
import com.example.demo.models.user.UserEntity;
import com.example.demo.models.user.UserRequest;
import com.example.demo.models.user.UserResponse;
import com.example.demo.repositories.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserEntity findById(Long Id) {
        Optional<UserEntity> byId = userRepository.findById(Id);
        return byId
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User Not Found"));
    }

    public UserResponse createUser(UserRequest userRequest) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUserName(userRequest.getUserName());
        userEntity.setName(userRequest.getName());
        UserEntity save = userRepository.save(userEntity);

        return UserMapper.mapEntityToResponse(save);
    }

    public UserResponse view(Long id) {
        return UserMapper.mapEntityToResponse(findById(id));
    }
}
