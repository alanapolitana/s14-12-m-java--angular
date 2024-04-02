package com.example.app.dto.user;

import com.example.app.model.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.io.Serializable;

/**
 * DTO for {@link com.example.app.model.User}
 */
public record UserToSignUpDto(
  @NotBlank(message = "El nombre es requerido")
  String firstName,
  @NotBlank(message = "El apellido es requerido")
  String lastName,
  @NotBlank(message = "El username es requerido")
  String userName,
  @NotBlank(message = "El numero de teléfono es requerido")
  String phone,
  @NotBlank(message = "El email es requerido")
  @Email(message = "El email no es válido")
  String email,
  @NotBlank(message = "La contraseña es requerida")
  @Size(min = 8, message = "La contraseña debe tener al menos 8 caracteres")
  String password,
  Role role,
  boolean active

) implements Serializable {

  public UserToSignUpDto {

    active = true;

    if (role == null) {
      role = Role.CUSTOMER;
    }

  }
}