package com.example.app.dto.user;

import com.example.app.model.Role;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.io.Serializable;

/**
 * DTO for {@link com.example.app.model.User}
 */
public record UserToSignUpDto(
  @NotBlank(message = "El nombre completo es requerido")
  @Pattern(regexp = "^[a-zA-Z]+(\\s[a-zA-Z]+)+$", message = "El nombre completo debe contener solo letras y espacios, y debe incluir un nombre y un apellido")
  String fullName,
  @NotBlank(message = "El numero de teléfono es requerido")
  @Pattern(regexp = "^[0-9]{10}$", message = "El número de teléfono deben ser dígitos y de longitud 10")
  String phone,
  @NotBlank(message = "El email es requerido")
    @Pattern(regexp = "^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,6}+$", message = "El email no es válido")
  String email,
  @NotBlank(message = "La contraseña es requerida")
  @Size(min = 8, message = "La contraseña debe tener al menos 8 caracteres")
  @Size(max = 16, message = "La contraseña debe tener como máximo 16 caracteres")
  String password,

  @JsonIgnore
  String alias,

  @JsonIgnore
  Role role,

  @JsonIgnore
  boolean active

) implements Serializable {

  public UserToSignUpDto {

    active = true;

    if (role == null) {
      role = Role.CUSTOMER;
    }

  }
}