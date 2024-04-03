package com.example.app.promocion.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PromocionDto {
    private Long id;
    private String descripcion;
    private String code;
    private Double porcentaje;
}
