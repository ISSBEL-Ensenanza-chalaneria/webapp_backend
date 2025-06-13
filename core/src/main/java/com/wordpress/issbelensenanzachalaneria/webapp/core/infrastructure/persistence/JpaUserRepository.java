package com.wordpress.issbelensenanzachalaneria.webapp.core.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaUserRepository extends JpaRepository<UserEntity, Long>{}
