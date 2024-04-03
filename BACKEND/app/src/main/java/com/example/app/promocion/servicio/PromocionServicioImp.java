package com.example.app.promocion.servicio;

import com.example.app.promocion.dto.PromocionDto;
import com.example.app.promocion.entidades.Promocion;
import com.example.app.promocion.mapeo.PromocionMapeo;
import com.example.app.promocion.repositorio.PromocionRepositorio;
import com.example.app.promocion.servicio.exepcion.ResourceNotFoundExepcion;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PromocionServicioImp implements PromocionServicio {
    
    private PromocionRepositorio promocionRepositorio;
    
    @Override
    public PromocionDto crearPromocion(PromocionDto promocionDto) {
        Promocion promocion = PromocionMapeo.map_promocionDto(promocionDto);
        Promocion promocionGuardado = promocionRepositorio.save(promocion);
        return PromocionMapeo.map_promocion(promocionGuardado);
    }
    
    @Override
    public PromocionDto buscarPromocionPorId(Long id) {
        Promocion promocion = promocionRepositorio.findById(id).orElseThrow(() -> new ResourceNotFoundExepcion("Esta Promocion no Existe con ese ID: " + id));
        return PromocionMapeo.map_promocion(promocion);
    }
    
    @Override
    public List<PromocionDto> listarPromociones() {
        List<Promocion> promociones = (List<Promocion>) promocionRepositorio.findAll();
        return promociones.stream()
                .map(promocion -> PromocionMapeo.map_promocion(promocion))
                .collect(Collectors.toList());
    }
    
    @Override
    public PromocionDto actualizarPromocion(Long id, PromocionDto promocionActualizar) {
        Promocion promocion = promocionRepositorio.findById(id).orElseThrow(() -> new ResourceNotFoundExepcion("Esta Promocion no Existe con ese ID: " + id));
        
        promocion.setDescripcion(promocionActualizar.getDescripcion());
        promocion.setCode(promocionActualizar.getCode());
        promocion.setPorcentaje(promocionActualizar.getPorcentaje());
        
        Promocion promocionActualizada = promocionRepositorio.save(promocion);
        
        return PromocionMapeo.map_promocion(promocionActualizada);
    }
    
    @Override
    public void borrarPromocion(Long id) {
        Promocion promocion = promocionRepositorio.findById(id).orElseThrow(() -> new ResourceNotFoundExepcion("Esta Promocion no Existe con ese ID: " + id));
        
        promocionRepositorio.delete(promocion);
    }
    
}
