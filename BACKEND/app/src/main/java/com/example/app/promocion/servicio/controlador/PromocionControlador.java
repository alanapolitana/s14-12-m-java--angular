package com.example.app.promocion.servicio.controlador;

import com.example.app.promocion.dto.PromocionDto;
import com.example.app.promocion.servicio.PromocionServicio;
import com.example.app.promocion.servicio.exepcion.ResourceNotFoundExepcion;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api/promo")
public class PromocionControlador {

    private final PromocionServicio PromocionServicio;

    @PostMapping(value = "guardar")
    public ResponseEntity<PromocionDto> crearPromocion(@RequestBody PromocionDto promocionDto) {
        PromocionDto guardarPromocion = PromocionServicio.crearPromocion(promocionDto);
        return new ResponseEntity<>(guardarPromocion, HttpStatus.CREATED);
    }
    
    @GetMapping(value = "buscarPorId/{id}")
    public ResponseEntity<?> buscarPromocionPorId(@PathVariable("id") Long id) {
        try {
            PromocionDto promocionDto = PromocionServicio.buscarPromocionPorId(id);
            return ResponseEntity.ok(promocionDto);
        } catch (ResourceNotFoundExepcion ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }
    
    @GetMapping(value = "listar")
    public ResponseEntity<List<PromocionDto>> listarPromocion() {
        List<PromocionDto> promocionDto = PromocionServicio.listarPromociones();
        return ResponseEntity.ok(promocionDto);
    }
    
    @PutMapping(value = "actualizar/{id}")
    public ResponseEntity<PromocionDto> actualizarPromocionX(@PathVariable("id") Long id, @RequestBody PromocionDto promocionActualizar) {
        PromocionDto promocionDto = PromocionServicio.actualizarPromocion(id, promocionActualizar);
        return ResponseEntity.ok(promocionDto);
    }
    
    @DeleteMapping(value = "eliminar/{id}")
    public ResponseEntity<String> borrarPromocion(@PathVariable("id")Long id) {
        PromocionServicio.borrarPromocion(id);
        return ResponseEntity.ok("La Promocion se elimino");
    }

}
