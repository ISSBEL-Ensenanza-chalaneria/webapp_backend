package com.wordpress.issbelensenanzachalaneria.webapp.core.infrastructure.persistence;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Phones")
public class PhoneEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "phone_id")
    private String id;
    @Column(name = "phone_number")
    private String number;

    @ManyToOne
    private UserEntity user;
    
    @CreationTimestamp
    @Column(name = "phone_created_at")
    private LocalDateTime createdAt;
    @UpdateTimestamp
    @Column(name = "phone_updated_at")
    private LocalDateTime updatedAt;
}
