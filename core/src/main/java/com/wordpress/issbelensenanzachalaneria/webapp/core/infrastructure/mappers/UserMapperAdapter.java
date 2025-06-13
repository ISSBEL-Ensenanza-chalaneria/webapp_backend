package com.wordpress.issbelensenanzachalaneria.webapp.core.infrastructure.mappers;

import com.wordpress.issbelensenanzachalaneria.webapp.core.domain.users.User;
import com.wordpress.issbelensenanzachalaneria.webapp.core.domain.users.UserDto;
import com.wordpress.issbelensenanzachalaneria.webapp.core.domain.users.UserMapper;

public class UserMapperAdapter implements UserMapper {
    
    private final UserMapstructMapper mapper;

    public UserMapperAdapter(UserMapstructMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public UserDto fromEntity(User user) {
        return mapper.fromEntity(user);
    }

    @Override
    public User toEntity(UserDto user) {
        return mapper.toEntity(user);
    }
    
}
