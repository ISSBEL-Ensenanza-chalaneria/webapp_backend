package com.wordpress.issbelensenanzachalaneria.webapp.core.infrastructure.persistence;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.CreationTimestamp;

import com.wordpress.issbelensenanzachalaneria.webapp.core.domain.users.IDType;
import com.wordpress.issbelensenanzachalaneria.webapp.core.domain.users.User;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "users", uniqueConstraints = @UniqueConstraint(columnNames = {"user_email"}))
public class UserEntity {
    @Id
    @Column(name = "user_id")
    private Long id;

    @Column(name = "user_id_type")
    @Enumerated(value = EnumType.STRING)
    private IDType idType;

    @Column(name = "user_name")
    private String name;
    @Column(name = "user_email")
    private String email;

    @OneToMany
    private Set<PhoneEntity> phones = new HashSet<>();

    @CreationTimestamp
    @Column(name = "user_created_at")
    private LocalDateTime createdAt;
    @CreationTimestamp
    @Column(name = "user_updated_at")
    private LocalDateTime updatedAt;

    public static UserEntity fromdomain(User user) {
        var entity = new UserEntity();
        entity.id = user.getId();
        entity.idType = user.getIdType();
        entity.name = user.getName();
        entity.email = user.getEmail();
        //entity.phones = user.getPhones();
        entity.createdAt = LocalDateTime.now();
        entity.updatedAt = LocalDateTime.now();

        return entity;
    }

    public User toDomain() {
        var user = new User();
        user.setId(this.id);
        user.setIdType(this.idType);
        user.setName(this.name);
        user.setEmail(this.email);
        //user.setPhones(this.phones);
        user.setCreatedAt(LocalDateTime.now());
        user.setUpdatedAt(LocalDateTime.now());

        return user;
    }
}
