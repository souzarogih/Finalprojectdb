package com.higor.finalprojectdb.Product.repository;

import com.higor.finalprojectdb.Product.model.Product;
import com.higor.finalprojectdb.QueryInteractive.dto.ProductDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {

    Optional<Product> findAllById(UUID id);

    @Query("SELECT id com.higor.finalprojectdb.Product.model.ProductDTO(p.id, p.price) FROM Product p")
    List<ProductDTO> findAllIdsAndPrices();

}
