package com.example.app.promocion.repositorio;

import com.example.app.promocion.entidades.Promotion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PromotionRepository extends CrudRepository<Promotion, Long>{
    
}
