package br.com.alurafood.promotions.controller;

import br.com.alurafood.promotions.dto.PromotionDto;
import br.com.alurafood.promotions.service.PromotionService;
import br.com.alurafood.promotions.service.PromotionValidateRole;
import br.com.alurafood.promotions.service.PromotionValidateTime;
import br.com.alurafood.promotions.service.PromotionValidation;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/promotions")
public class PromotionController {

        @Autowired
        private PromotionService promotionService;

        @GetMapping()
        public List<PromotionDto> list() {
            return promotionService.findAll();
        }

        @GetMapping("/{id}")
        public ResponseEntity<PromotionDto> orderById(@PathVariable @NotNull Long id) {
            PromotionDto dto = promotionService.findById(id);
            return  ResponseEntity.ok(dto);
        }

        @PostMapping()
        public ResponseEntity<PromotionDto> create(@RequestBody @Valid PromotionDto dto) {
            List<PromotionValidation> validations = Arrays.asList(new PromotionValidateRole(), new PromotionValidateTime());
            return ResponseEntity.ok(promotionService.create(dto, validations));
        }

        @PutMapping("/{id}")
        public ResponseEntity<PromotionDto> edit(@RequestBody @Valid PromotionDto dto, @PathVariable @NotNull Long id){
            List<PromotionValidation> validations = List.of(new PromotionValidateRole(), new PromotionValidateTime());
            return ResponseEntity.ok(promotionService.update(dto, id, validations));
        }
}
