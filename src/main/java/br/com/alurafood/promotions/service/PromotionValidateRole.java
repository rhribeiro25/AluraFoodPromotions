package br.com.alurafood.promotions.service;

import br.com.alurafood.promotions.exceptions.PromotionValidationException;
import br.com.alurafood.promotions.model.Promotion;
import br.com.alurafood.promotions.model.PromotionStatus;

public class PromotionValidateRole implements PromotionValidation {
    
    @Override
    public void validate(Promotion promotion) {
        if(promotion.getStatus().equals(PromotionStatus.CANCELED)){
            throw new PromotionValidationException("Canceled promotion");
        }
        //else ...
    }
}
