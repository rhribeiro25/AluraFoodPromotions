package br.com.alurafood.promotions.dto;

import java.time.LocalDateTime;

public class PromotionDto {

    private Long id;

    private Integer discountPercentage;

    private String name;

    private String status;

    private Long productId;

    private LocalDateTime startDate;

    private LocalDateTime finishDate;
}
