package com.higor.finalprojectdb.Sale.dto;

import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TotalBaseDto {

    private Integer totalSales;
    private Integer totalProducts;
    private Integer totalUsers;
    private Integer totalSalePix;
    private Integer totalSaleCard;
    private Integer totalSaleCash;
}
