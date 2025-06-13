package com.wordpress.issbelensenanzachalaneria.webapp.core.application.userUseCases;

import com.wordpress.issbelensenanzachalaneria.webapp.core.domain.users.UserDto;
import com.wordpress.issbelensenanzachalaneria.webapp.core.domain.users.UserMapper;
import com.wordpress.issbelensenanzachalaneria.webapp.core.domain.users.UserRepository;
import com.wordpress.issbelensenanzachalaneria.webapp.core.shared_kernel.response.ApiResponse;

public class UserCrudUseCases {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserCrudUseCases(UserRepository repository, UserMapper mapper) {
        userRepository = repository;
        userMapper = mapper;
    }

    public ApiResponse register(UserDto dto) {
        return userRepository.save(
            userMapper.toEntity(dto)
        );
    }
}
