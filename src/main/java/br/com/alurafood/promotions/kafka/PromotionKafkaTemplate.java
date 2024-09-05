package br.com.alurafood.promotions.kafka;

import br.com.alurafood.promotions.dto.PromotionDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class PromotionKafkaTemplate {

    @Value("${kafka.topic.name}")
    private String topic;

    private final KafkaTemplate<String, PromotionDto>  kafkaTemplate;

    public void sendPromotionToProduct(@RequestBody PromotionDto promotionDto) {
        kafkaTemplate.send(topic, UUID.randomUUID().toString(), promotionDto);
    }

}
