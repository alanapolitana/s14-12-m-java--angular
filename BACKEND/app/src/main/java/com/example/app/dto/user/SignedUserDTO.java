package com.example.app.dto.user;

import com.example.app.model.Role;

import java.io.Serializable;

/**
 * DTO for {@link com.example.app.model.User}
 */
public record SignedUserDTO(
  boolean isError,
  Long id,
  String firstName,
  String lastName,
  String alias,
  String phone,
  String email,
  Role role,
  boolean active

) implements Serializable {
    public SignedUserDTO {
        isError = false;
    }
}