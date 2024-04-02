package com.example.app.controller;

import com.example.app.dto.user.SignedUserDTO;
import com.example.app.dto.user.UserToSignUpDto;
import com.example.app.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    @Transactional
    public ResponseEntity<SignedUserDTO> signUp(
      @RequestBody @Valid UserToSignUpDto userToSignUpDto,
      UriComponentsBuilder uriComponentsBuilder,
      HttpServletRequest request
    ) {

        // Sign up the user
        SignedUserDTO userSignedUpDto = userService.signUp(userToSignUpDto, request);

        // Build the location URI
        URI location = uriComponentsBuilder
          .path("/users/{id}")
          .buildAndExpand(userSignedUpDto.id())
          .toUri();

        // Return the response
        return ResponseEntity
          .created(location)
          .body(userSignedUpDto);
    }
}
