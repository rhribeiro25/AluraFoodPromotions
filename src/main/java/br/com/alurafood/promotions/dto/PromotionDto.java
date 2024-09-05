package br.com.alurafood.promotions.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PromotionDto {


    private Long id;

    @NotNull
    @Positive
    private Integer discountPercentage;

    @NotBlank
    @Size(max = 124)
    private String name;

    private String status;

    @NotNull
    private Long productId;

    @NotNull
    private LocalDateTime startDate;

    @NotNull
    private LocalDateTime finishDate;
}
