package com.higor.finalprojectdb.Product.repository;

import com.higor.finalprojectdb.Product.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {

    @Query(value = "SELECT count(p.*) FROM Product p", nativeQuery = true)
    Integer findTotalProducts();
}
