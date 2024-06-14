package com.higor.finalprojectdb.Sale.model;

import com.higor.finalprojectdb.Product.model.Product;
import com.higor.finalprojectdb.User.model.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Sale implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product productId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User userId;


    @Column(name = "payment_type")
    private String paymentType;

    @Column(name = "sale_date")
    private LocalDateTime saleDate;

    private Integer installments;

    @Column(name = "sales_value")
    private BigDecimal salesValue;

    @Column(name = "estimated_delivery_date")
    private Integer estimatedDeliveryDate;

    @Column(name = "delivery_date")
    private Integer deliveryDate;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

}
