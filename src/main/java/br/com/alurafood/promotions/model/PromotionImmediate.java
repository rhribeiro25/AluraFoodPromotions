package br.com.alurafood.promotions.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.Period;

@Entity
@Table(name = "promotions_immediate")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PromotionImmediate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade=CascadeType.PERSIST)
    private PromotionData promotionData;

    private Integer discountPercentage;

    private LocalDateTime startDate;

    private LocalDateTime finishDate;

    public Period getPromotionPeriod(){
        return Period.between(startDate.toLocalDate(), finishDate.toLocalDate());
    }
}
