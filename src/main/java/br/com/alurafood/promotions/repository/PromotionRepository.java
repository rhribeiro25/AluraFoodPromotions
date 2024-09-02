package br.com.alurafood.promotions.repository;

import br.com.alurafood.promotions.model.Promotion;
import br.com.alurafood.promotions.model.PromotionStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PromotionRepository extends JpaRepository<Promotion, Long> {
    Promotion findPromotionById(Long id);
    List<Promotion> findAllByStatus(PromotionStatus status);
}
