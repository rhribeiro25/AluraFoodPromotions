package br.com.alurafood.promotions.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "promotions_coupon")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PromotionCoupon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade=CascadeType.PERSIST)
    private PromotionData promotionData;

    private Integer discountPercentage;

}
