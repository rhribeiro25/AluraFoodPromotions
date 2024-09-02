package br.com.alurafood.promotions.kafka;

import br.com.alurafood.promotions.dto.PromotionDto;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PromotionKafkaTemplate {

    private final KafkaTemplate<String, PromotionDto>  kafkaTemplate;

    public PromotionDto salvarPix(PromotionDto pixDTO) {
        kafkaTemplate.send("pix-topic", pixDTO);
        return pixDTO;
    }

}
