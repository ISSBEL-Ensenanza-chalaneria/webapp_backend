package com.wordpress.issbelensenanzachalaneria.webapp.core.domain.users;

public interface UserMapper {
    UserDto fromEntity(User user);

    User toEntity(UserDto user);
}
