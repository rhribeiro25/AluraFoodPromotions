//package br.com.alurafood.promotions.kafka;
//
//import br.com.alurafood.promotions.dto.PromotionDto;
//import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.kafka.annotation.RetryableTopic;
//import org.springframework.retry.annotation.Backoff;
//import org.springframework.stereotype.Service;
//
//@Service
//public class PromotionKafkaListener {
//
//    @KafkaListener(topics = "promotion-to-order-topic-2", groupId = "alura-food")
//    @RetryableTopic(
//            backoff = @Backoff(value = 3000L),
//            attempts = "5",
//            autoCreateTopics = "true",
//            include = RuntimeException.class)
//    public void process(PromotionDto pixDTO) {
//        if (10>0) {
//            System.out.println(PromotionDto.class);
//        } else  {
//            throw new RuntimeException();
//        }
//
//    }
//
//
//}
