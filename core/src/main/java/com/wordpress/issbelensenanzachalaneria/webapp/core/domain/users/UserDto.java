package com.wordpress.issbelensenanzachalaneria.webapp.core.domain.users;

import java.util.Set;

import com.wordpress.issbelensenanzachalaneria.webapp.core.domain.phones.Phone;

public record UserDto(
    Long id,
    IDType idType,
    String name,
    String email,

    Set<Phone> phones
)
{}
