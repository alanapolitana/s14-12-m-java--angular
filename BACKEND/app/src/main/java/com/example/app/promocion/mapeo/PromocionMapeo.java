package com.example.app.promocion.mapeo;

import com.example.app.promocion.dto.PromocionDto;
import com.example.app.promocion.entidades.Promocion;

public class PromocionMapeo {

    public static PromocionDto map_promocion(Promocion promocion) {
        return new PromocionDto(
                promocion.getId(),
                promocion.getDescripcion(),
                promocion.getCode(),
                promocion.getPorcentaje()
        );
    }

    public static Promocion map_promocionDto(PromocionDto promocionDto) {
        return new Promocion(
                promocionDto.getId(),
                promocionDto.getDescripcion(),
                promocionDto.getCode(),
                promocionDto.getPorcentaje()
        );
    }

}
