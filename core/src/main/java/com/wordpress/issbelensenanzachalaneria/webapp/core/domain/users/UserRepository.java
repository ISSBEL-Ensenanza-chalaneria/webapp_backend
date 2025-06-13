package com.wordpress.issbelensenanzachalaneria.webapp.core.domain.users;

import com.wordpress.issbelensenanzachalaneria.webapp.core.shared_kernel.response.ApiResponse;

public interface UserRepository {
    ApiResponse save(User user);
}
