package com.example.app.dto.user;

import jakarta.validation.constraints.NotBlank;

import java.io.Serializable;

/**
 * DTO for {@link com.example.app.model.User}
 */
public record UserToLoginDto(
  @NotBlank(message = "El email es requerido")
  String email,
  @NotBlank(message = "El password es requerido")
  String password

) implements Serializable {
}