package com.example.app.controller;

import com.example.app.dto.user.LoggedUserDto;
import com.example.app.dto.user.SignedUserDTO;
import com.example.app.dto.user.UserToLoginDto;
import com.example.app.dto.user.UserToSignUpDto;
import com.example.app.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirements;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Tag(name = "Users", description = "Manage all endpoints about Users")
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @Operation(
      summary = "Sign up a new User.",
      description = "Let a user sign up."
    )
    @ApiResponses(value = {
      @ApiResponse(
        responseCode = "200", description = "User created successfully",
        content = {
          @Content(mediaType = "application/json",
            schema = @Schema(implementation = SignedUserDTO.class))
        }),
      @ApiResponse(responseCode = "400", description = "User Already Exists", content = {@Content}),
      @ApiResponse(responseCode = "404", description = "Not Found", content = {@Content}),
      @ApiResponse(responseCode = "500", description = "Internal Server Error", content = {@Content})
    })
    @SecurityRequirements()
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

    @PostMapping("/auth")
    @Transactional
    public ResponseEntity<LoggedUserDto> login(@RequestBody @Valid UserToLoginDto userToLoginDto) {

        return ResponseEntity
          .status(HttpStatus.OK)
          .body(userService.login(userToLoginDto));
    }
}
