package com.higor.finalprojectdb.Sale.dto;

import com.higor.finalprojectdb.Product.model.Product;
import com.higor.finalprojectdb.User.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaleResponse {

    private UUID id;
    private Product productId;
    private User userId;
    private String paymentType;
    private LocalDateTime saleDate;
    private Integer installments;
    private BigDecimal salesValue;
    private Integer estimatedDeliveryDate;
    private Integer deliveryDate;
    private LocalDateTime createdAt;
}
