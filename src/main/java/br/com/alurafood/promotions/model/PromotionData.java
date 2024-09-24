package br.com.alurafood.promotions.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "promotion_data")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PromotionData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private PromotionStatus status;

    private Long productId;
}
