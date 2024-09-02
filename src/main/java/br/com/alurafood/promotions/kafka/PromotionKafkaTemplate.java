package br.com.alurafood.promotions.kafka;

import br.com.alurafood.promotions.dto.PromotionDto;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PromotionKafkaTemplate {

    private final KafkaTemplate<String, PromotionDto>  kafkaTemplate;

    public PromotionDto salvarPix(PromotionDto promotionDto) {
        kafkaTemplate.send("promotion-to-order-topic-2", promotionDto);
        return promotionDto;
    }

}
