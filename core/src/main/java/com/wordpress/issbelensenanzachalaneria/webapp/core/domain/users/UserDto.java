package com.wordpress.issbelensenanzachalaneria.webapp.core.domain.users;

import java.util.HashSet;
import java.util.Set;

import com.wordpress.issbelensenanzachalaneria.webapp.core.domain.phones.Phone;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserDto {
    @Min(value = 0, message = "El número de identificación no puede ser menor a 0")
    Long id;
    IDType idType;
    @NotEmpty(message = "El campo nombre no puede estar vacío")
    @Size(min = 3, max = 250, message = "El nombre debe tener al menos 3 caracteres y menos de 250")
    String name;
    @Email(message = "Ingresa un email válido")
    @NotEmpty(message = "El campo email no puede estar vacío")
    String email;

    Set<Phone> phones = new HashSet<>();
}
