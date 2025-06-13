package com.wordpress.issbelensenanzachalaneria.webapp.core.infrastructure.persistence;

import org.springframework.stereotype.Repository;

import com.wordpress.issbelensenanzachalaneria.webapp.core.domain.users.User;
import com.wordpress.issbelensenanzachalaneria.webapp.core.domain.users.UserRepository;
import com.wordpress.issbelensenanzachalaneria.webapp.core.shared_kernel.response.ApiResponse;
import com.wordpress.issbelensenanzachalaneria.webapp.core.shared_kernel.utils.ResponseUtil;

@Repository
public class UserRepositoryAdapter implements UserRepository {

    private final JpaUserRepository jpaRepository;

    public UserRepositoryAdapter(JpaUserRepository jpaUserRepository) {
        this.jpaRepository = jpaUserRepository;
    }
    
    @Override
    public ApiResponse save(User user) {
        boolean userCreatedBefore = jpaRepository.findById(user.getId()).isPresent();
        if (userCreatedBefore) {
            return ResponseUtil.response(-1);
        }
        jpaRepository.save(UserEntity.fromdomain(user));
        return ResponseUtil.response(1);
    }
}
