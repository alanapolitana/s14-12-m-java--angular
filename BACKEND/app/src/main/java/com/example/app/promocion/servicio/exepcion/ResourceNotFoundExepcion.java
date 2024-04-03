package com.example.app.promocion.servicio.exepcion;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundExepcion extends RuntimeException {

    public ResourceNotFoundExepcion(String mensaje) {
        super(mensaje);
    }
}
