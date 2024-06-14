package com.higor.finalprojectdb.QueryInteractive.service;

import com.higor.finalprojectdb.Product.dto.ProductResponse;
import com.higor.finalprojectdb.Product.model.Product;
import com.higor.finalprojectdb.Product.repository.ProductRepository;
import com.higor.finalprojectdb.User.repository.UserRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

@Log4j2
@Service
public class QueryInteractiveService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    UserRepository userRepository;


    public List<ProductResponse> findAll() {
        return productRepository.findAll().stream()
                .map(product -> new ProductResponse(
                        product.getId(),
                        product.getProductName(),
                        product.getProductCode(),
                        product.getProductCategory(),
                        product.getPrice(),
                        product.getCreatedAt(),
                        product.getUpdatedAt()
                )).collect(Collectors.toList());
    }

    public List<Object> findByField(String field) {
        log.info("findByField {}", field);

        switch (field){

            case "id":
                return productRepository.findAll().stream().map(Product::getId).collect(Collectors.toList());

            case "price":
                return productRepository.findAll().stream().map(Product::getPrice).collect(Collectors.toList());

            case "product_category":
                return productRepository.findAll().stream().map(Product::getProductCategory).collect(Collectors.toList());

            case "product_code":
                return productRepository.findAll().stream().map(Product::getProductCode).collect(Collectors.toList());

            case "created_at":
                return productRepository.findAll().stream().map(Product::getCreatedAt).collect(Collectors.toList());

            case "updated_at":
                return productRepository.findAll().stream().map(Product::getUpdatedAt).collect(Collectors.toList());

            default:
                return null;


        }


    }

}
