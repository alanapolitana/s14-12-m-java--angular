package com.example.app.controller;

import com.example.app.dto.AddressDTO;
import com.example.app.service.AddressService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;

@RequiredArgsConstructor

@RestController
@RequestMapping("/addresses")
public class AddressController {

    private final AddressService addressService;

    @PostMapping
    public ResponseEntity<?> registerAddress(@RequestBody @Valid AddressDTO addressDTO)
            throws URISyntaxException {
        addressService.registerAddress(addressDTO);
        return ResponseEntity.created(new URI("/addresses")).build();
    }
}
