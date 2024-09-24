package br.com.alurafood.promotions.repository;

import br.com.alurafood.promotions.model.PromotionImmediate;
import br.com.alurafood.promotions.model.PromotionStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PromotionRepository extends JpaRepository<PromotionImmediate, Long> {
    PromotionImmediate findPromotionById(Long id);
    List<PromotionImmediate> findAllByStatus(PromotionStatus status);
}
