package com.example.app.dto.user;

import java.io.Serializable;

/**
 * DTO for {@link com.example.app.model.User}
 */
public record LoggedUserDto(
  boolean isError,
  Long id,
  String firstName,
  String lastName,
  String email,
  String token

) implements Serializable {
    public LoggedUserDto {
        isError = false;
    }
}