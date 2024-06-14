package com.higor.finalprojectdb.Sale.repository;

import com.higor.finalprojectdb.Sale.model.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface SaleRepository extends JpaRepository<Sale, UUID> {

    @Query(value = "SELECT s.* FROM Sale s where s.payment_type = :paymentType", nativeQuery = true)
    List<Sale> listSalePaymentType(String paymentType);

    @Query(value = "SELECT count(s.*) FROM Sale s where s.payment_type = :paymentType", nativeQuery = true)
    Integer findTotalSalePaymentType(String paymentType);

    @Query(value = "SELECT count(s.*) FROM Sale s", nativeQuery = true)
    Integer findTotalSales();

    @Query(value = "SELECT s.* FROM Sale s where s.user_id = :userId", nativeQuery = true)
    List<Sale> getSalesByUserId(UUID userId);




}
