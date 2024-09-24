package br.com.alurafood.promotions.service;

import br.com.alurafood.promotions.exceptions.PromotionValidationException;
import br.com.alurafood.promotions.model.PromotionImmediate;

public class PromotionValidateTime implements PromotionValidation {

    @Override
    public void validate(PromotionImmediate promotionImmediate) {
        if(promotionImmediate.getStartDate().isAfter(promotionImmediate.getFinishDate())){
            throw new PromotionValidationException("The start date cannot be less than the end date");
        }
        //else...
    }
}
