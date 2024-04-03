package com.example.app.dto.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.io.Serializable;

/**
 * DTO for {@link com.example.app.model.User}
 */
public record UserToLoginDto(
  @NotBlank(message = "El email es requerido")
  @Email(message = "El email no es válido")
  String email,
  @NotBlank(message = "El password es requerido")
  @Size(min = 8, message = "La contraseña debe tener al menos 8 caracteres")
  String password

) implements Serializable {
}