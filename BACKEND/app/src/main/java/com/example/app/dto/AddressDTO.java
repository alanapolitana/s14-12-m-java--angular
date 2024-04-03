package com.example.app.dto;

import com.example.app.dto.user.SignedUserDTO;
import jakarta.validation.constraints.NotBlank;

import java.io.Serializable;

/**
 * DTO for {@link com.example.app.model.Address}
 */
public record AddressDTO(


        SignedUserDTO user,

        @NotBlank(message = "La provincia es requerida")
        String province,

        @NotBlank(message = "La localidad es requerida")
        String locality,

        @NotBlank(message = "El numero de su recidencia es requerido")
        String streetNumber,

        String referencePoint

) implements Serializable {
}