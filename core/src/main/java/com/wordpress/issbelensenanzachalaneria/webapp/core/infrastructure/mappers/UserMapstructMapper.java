package com.wordpress.issbelensenanzachalaneria.webapp.core.infrastructure.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.wordpress.issbelensenanzachalaneria.webapp.core.domain.users.User;
import com.wordpress.issbelensenanzachalaneria.webapp.core.domain.users.UserDto;

@Mapper(componentModel = "spring")
public interface UserMapstructMapper {
    UserDto fromEntity(User user);

    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    User toEntity(UserDto dto);
}
