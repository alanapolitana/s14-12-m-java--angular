package com.example.app.dto.address;

import jakarta.validation.constraints.NotBlank;

import java.io.Serializable;

public record AddressUpdateDataDTO(

        @NotBlank(message = "El numero de su recidencia es requerido")
        String streetNumber,

        String referencePoint

) implements Serializable {
}
