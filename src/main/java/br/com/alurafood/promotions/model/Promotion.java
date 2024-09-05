package br.com.alurafood.promotions.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "promotions")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Promotion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer discountPercentage;

    private String name;

    @Enumerated(EnumType.STRING)
    private PromotionStatus status;

    private Long productId;

    private LocalDateTime startDate;

    private LocalDateTime finishDate;
}
