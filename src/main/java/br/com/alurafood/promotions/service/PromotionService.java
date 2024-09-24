package br.com.alurafood.promotions.service;

import br.com.alurafood.promotions.dto.PromotionDto;
import br.com.alurafood.promotions.kafka.PromotionKafkaTemplate;
import br.com.alurafood.promotions.model.PromotionImmediate;
import br.com.alurafood.promotions.model.PromotionStatus;
import br.com.alurafood.promotions.repository.PromotionRepository;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PromotionService {

    @Autowired
    private PromotionRepository promotionRepository;

    @Autowired
    private PromotionKafkaTemplate promotionKafkaTemplate;

    @Autowired
    private ModelMapper modelMapper;


    public List<PromotionDto> findAll() {
        return promotionRepository.findAllByStatus(PromotionStatus.VALID).stream()
                .map(p -> modelMapper.map(p, PromotionDto.class))
                .collect(Collectors.toList());
    }

    public PromotionDto findById(Long id) {
        PromotionImmediate promotionImmediate = promotionRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
        return modelMapper.map(promotionImmediate, PromotionDto.class);
    }

    public PromotionDto create(PromotionDto dto, List<PromotionValidation> validations) {
        PromotionImmediate promotionImmediate = modelMapper.map(dto, PromotionImmediate.class);
        promotionImmediate.getPromotionData().setStatus(PromotionStatus.VALID);
        validations.forEach(v -> v.validate(promotionImmediate));
        PromotionImmediate promotionImmediateSave = promotionRepository.save(promotionImmediate);
        PromotionDto promotionSaved = modelMapper.map(promotionImmediateSave, PromotionDto.class);
        promotionKafkaTemplate.sendPromotionToProduct(promotionSaved);
        return promotionSaved;
    }

    public PromotionDto update(PromotionDto promotionDto, Long id, List<PromotionValidation> validations) {
        if (promotionRepository.findPromotionById(id) == null) {
            throw new EntityNotFoundException();
        }
        PromotionImmediate promotionImmediate = modelMapper.map(promotionDto, PromotionImmediate.class);
        validations.forEach(v -> v.validate(promotionImmediate));
        promotionImmediate.setId(id);
        promotionRepository.save(promotionImmediate);
        return modelMapper.map(promotionImmediate, PromotionDto.class);
    }
}
