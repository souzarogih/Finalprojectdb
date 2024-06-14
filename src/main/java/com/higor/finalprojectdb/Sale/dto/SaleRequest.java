package com.higor.finalprojectdb.Sale.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaleRequest {

    private UUID productId;
    private UUID userId;
    private String paymentType;
    private Integer installments;
    private BigDecimal salesValue;
    private Integer estimatedDeliveryDate;
    private Integer deliveryDate;
}
