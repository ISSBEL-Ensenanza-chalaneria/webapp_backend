package com.wordpress.issbelensenanzachalaneria.webapp.core.domain.phones;

import java.time.LocalDateTime;

import com.wordpress.issbelensenanzachalaneria.webapp.core.domain.users.User;

import lombok.Data;

@Data
public class Phone {
    private String id;
    private String number;

    private User user;
    
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
