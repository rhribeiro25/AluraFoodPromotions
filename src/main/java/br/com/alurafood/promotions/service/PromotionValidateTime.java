package br.com.alurafood.promotions.service;

import br.com.alurafood.promotions.exceptions.PromotionValidationException;
import br.com.alurafood.promotions.model.Promotion;

public class PromotionValidateTime implements PromotionValidation {

    @Override
    public void validate(Promotion promotion) {
        if(promotion.getStartDate().isAfter(promotion.getFinishDate())){
            throw new PromotionValidationException("The start date cannot be less than the end date");
        }
        //else...
    }
}
