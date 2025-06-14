package com.wordpress.issbelensenanzachalaneria.webapp.core.infrastructure.mappers;

import org.mapstruct.Mapper;

import com.wordpress.issbelensenanzachalaneria.webapp.core.domain.users.User;
import com.wordpress.issbelensenanzachalaneria.webapp.core.domain.users.UserDto;

@Mapper(componentModel = "spring")
public interface UserMapstructMapper {
    UserDto fromEntity(User user);

    User toEntity(UserDto dto);
}
