package br.com.alurafood.promotions.service;

import br.com.alurafood.promotions.dto.PromotionDto;
import br.com.alurafood.promotions.model.Promotion;
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
    private ModelMapper modelMapper;


    public List<PromotionDto> findAll() {
        return promotionRepository.findAllByStatus(PromotionStatus.VALID).stream()
                .map(p -> modelMapper.map(p, PromotionDto.class))
                .collect(Collectors.toList());
    }

    public PromotionDto findById(Long id) {
        Promotion promotion = promotionRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
        return modelMapper.map(promotion, PromotionDto.class);
    }

    public PromotionDto create(PromotionDto dto) {
        Promotion promotion = modelMapper.map(dto, Promotion.class);
        promotion.setStatus(PromotionStatus.VALID);
        Promotion promotionSave = promotionRepository.save(promotion);
        return modelMapper.map(promotionSave, PromotionDto.class);
    }

    public PromotionDto update(PromotionDto promotionDto, Long id) {
        if (promotionRepository.findPromotionById(id) == null) {
            throw new EntityNotFoundException();
        }
        Promotion promotion = modelMapper.map(promotionDto, Promotion.class);
        promotion.setId(id);
        promotionRepository.save(promotion);
        return modelMapper.map(promotion, PromotionDto.class);
    }
}
