package com.wordpress.issbelensenanzachalaneria.webapp.core.domain.users;

import java.util.Set;

import com.wordpress.issbelensenanzachalaneria.webapp.core.domain.phones.Phone;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public record UserDto(
    @Min(value = 0, message = "El número de identificación no puede ser menor a 0")
    @Size(max = 12, message = "El número de identificación no puede tener más de 12 caracteres")
    @NotEmpty(message = "El  campo de identificación no puede estar vacío")
    Long id,
    IDType idType,
    @NotEmpty(message = "El campo nombre no puede estar vacío")
    @Size(min = 3, max = 250, message = "El nombre debe tener al menos 3 caracteres y menos de 250")
    String name,
    @Email(message = "Ingresa un email válido")
    @NotEmpty(message = "El campo email no puede estar vacío")
    String email,

    Set<Phone> phones
)
{}
