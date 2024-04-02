package com.example.app.dto.user;

import com.example.app.model.Role;

import java.io.Serializable;

/**
 * DTO for {@link com.example.app.model.User}
 */
public record SignedUserDTO(
  Long id,
  String firstName,
  String lastName,
  String userName,
  String phone,
  String email,
  Role role,
  boolean active

) implements Serializable {
}