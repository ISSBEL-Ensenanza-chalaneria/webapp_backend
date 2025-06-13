package com.wordpress.issbelensenanzachalaneria.webapp.core.domain.users;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import com.wordpress.issbelensenanzachalaneria.webapp.core.domain.phones.Phone;

import lombok.Data;

@Data
public class User {
    private Long id;
    private IDType idType;
    private String name;
    private String email;

    private Set<Phone> phones = new HashSet<>();

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
