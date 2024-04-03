package com.example.app.promocion.repositorio;

import com.example.app.promocion.entidades.Promocion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PromocionRepositorio extends CrudRepository<Promocion, Long>{
    
}
