package com.example.app.controller;

import com.example.app.dto.address.AddressDTO;
import com.example.app.dto.address.AddressPublicDataDTO;
import com.example.app.service.AddressService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirements;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RequiredArgsConstructor

@Tag(name = "Addresses", description = "Manage all endpoints about addresses")
@RestController
@RequestMapping("/addresses")
public class AddressController {

    private final AddressService addressService;

    @Operation(summary = "allows to register an address")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201", description = "Address created successfully",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = AddressDTO.class))
                    }),
            @ApiResponse(responseCode = "400", description = "Valid data required", content = {@Content}),
            @ApiResponse(responseCode = "403", description = "Requires authentication/permission", content = {@Content}),
            @ApiResponse(responseCode = "404", description = "Unregistered user", content = {@Content}),
            @ApiResponse(responseCode = "500", description = "There is a database problem", content = {@Content})
    })
    @PostMapping
    public ResponseEntity<?> registerAddress(@RequestBody @Valid AddressDTO addressDTO)
            throws URISyntaxException {
        addressService.registerAddress(addressDTO);
        return ResponseEntity.created(new URI("/addresses")).build();
    }

    @Operation(summary = "allows to obtain the addresses of a user")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200", description = "Addresses found successfully",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = AddressPublicDataDTO.class))
                    }),
            @ApiResponse(responseCode = "403", description = "Requires authentication/permission", content = {@Content}),
            @ApiResponse(responseCode = "404", description = "Unregistered user", content = {@Content}),
            @ApiResponse(responseCode = "500", description = "There is a database problem", content = {@Content})
    })
    @GetMapping("/{id}")
    public ResponseEntity<List<AddressPublicDataDTO>> findAllAddressByUserId(
            @PathVariable Long id){
        return ResponseEntity.ok().body(addressService.findAllByUserId(id));
    }
}
