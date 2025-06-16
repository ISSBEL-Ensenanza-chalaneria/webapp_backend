package com.wordpress.issbelensenanzachalaneria.webapp.core.infrastructure.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wordpress.issbelensenanzachalaneria.webapp.core.application.userUseCases.UserCrudUseCases;
import com.wordpress.issbelensenanzachalaneria.webapp.core.domain.users.UserDto;
import com.wordpress.issbelensenanzachalaneria.webapp.core.infrastructure.mappers.UserMapperAdapter;
import com.wordpress.issbelensenanzachalaneria.webapp.core.infrastructure.persistence.UserRepositoryAdapter;
import com.wordpress.issbelensenanzachalaneria.webapp.core.shared_kernel.response.ApiResponse;
import com.wordpress.issbelensenanzachalaneria.webapp.core.shared_kernel.response.HttpResponse;
import com.wordpress.issbelensenanzachalaneria.webapp.core.shared_kernel.utils.ResponseUtil;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping(path = "/api/users")
public class UserController {
    private final UserCrudUseCases userCrudUseCases;

    public UserController(UserRepositoryAdapter repositoryAdapter, UserMapperAdapter mapperAdapter) {
        userCrudUseCases = new UserCrudUseCases(repositoryAdapter, mapperAdapter);
    }

    @PostMapping(path = "/")
    public ResponseEntity<HttpResponse> register(@Valid @RequestBody UserDto user) {
        ApiResponse response = userCrudUseCases.register(user);
        if (response.getControlFlow() == -1) {
            return ResponseUtil.httpResponse("Usuario ya existe en la base de datos", HttpStatus.CONFLICT);
        }
        return ResponseUtil.httpResponse("", HttpStatus.CREATED);
    }
    
}
