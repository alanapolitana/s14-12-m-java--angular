package com.example.app.promocion.servicio;

import com.example.app.promocion.dto.PromocionDto;
import java.util.List;

public interface PromocionServicio {

    PromocionDto crearPromocion(PromocionDto promocionDto);

    PromocionDto buscarPromocionPorId(Long id);

    List<PromocionDto> listarPromociones();

    PromocionDto actualizarPromocion(Long id, PromocionDto promocionActualizar);

    void borrarPromocion(Long id);
}
