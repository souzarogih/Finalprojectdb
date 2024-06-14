package com.higor.finalprojectdb.Product.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequest {

    private String productName;

    private Long productCode;

    private String productCategory;

    private BigDecimal price;

}
