package com.example.app.dto.address;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;

/**
 * DTO for {@link com.example.app.model.Address}
 */
public record AddressDTO(

        @Valid
        @NotNull(message = "El usuario es requerido")
        UserToSaveAddress user,

        @NotBlank(message = "La provincia es requerida")
        String province,

        @NotBlank(message = "La localidad es requerida")
        String locality,

        @NotBlank(message = "El numero de su recidencia es requerido")
        String streetNumber,

        String referencePoint

) implements Serializable {
}