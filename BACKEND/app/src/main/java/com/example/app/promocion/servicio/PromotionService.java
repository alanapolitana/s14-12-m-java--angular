package com.example.app.promocion.servicio;

import com.example.app.promocion.dto.PromotionDto;
import java.util.List;

public interface PromotionService {

    PromotionDto createPromotion(PromotionDto promotionDto);

    PromotionDto findPromotionById(Long id);

    List<PromotionDto> listPromotions();

    PromotionDto updatePromotion(Long id, PromotionDto updatePromotion);

    void deletePromotion(Long id);
}
