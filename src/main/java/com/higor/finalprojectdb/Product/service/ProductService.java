package com.higor.finalprojectdb.Product.service;

import com.higor.finalprojectdb.Product.dto.ProductRequest;
import com.higor.finalprojectdb.Product.dto.ProductResponse;
import com.higor.finalprojectdb.Product.model.Product;
import com.higor.finalprojectdb.Product.repository.ProductRepository;
import com.higor.finalprojectdb.User.dto.UserResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Log4j2
@Service
public class ProductService {

    final String PRODUCT_NOT_FOUND_MESSAGE = "Product not found with id: ";

    @Autowired
    ProductRepository productRepository;

    public ProductResponse create(ProductRequest productRequest) {

        Product productSaved = productRepository.save(
                new Product(
                        UUID.randomUUID(),
                        productRequest.getProductName(),
                        productRequest.getProductCode(),
                        productRequest.getProductCategory(),
                        productRequest.getPrice(),
                        LocalDateTime.now(),
                        null
                        ));

        return new ProductResponse(
                productSaved.getId(),
                productSaved.getProductName(),
                productSaved.getProductCode(),
                productSaved.getProductCategory(),
                productSaved.getPrice(),
                productSaved.getCreatedAt(),
                productSaved.getUpdatedAt()
        );
    }

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

    public ProductResponse findById(UUID id) {
        return productRepository.findById(id)
                .map(product -> new ProductResponse(
                        product.getId(),
                        product.getProductName(),
                        product.getProductCode(),
                        product.getProductCategory(),
                        product.getPrice(),
                        product.getCreatedAt(),
                        product.getUpdatedAt()
                )).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, PRODUCT_NOT_FOUND_MESSAGE + id));
    }

    public ProductResponse update(UUID id, ProductRequest productRequest) {

        return productRepository.findById(id)
                .map(productData -> {
                    productData.setProductName(productRequest.getProductName());
                    productData.setProductCode(productRequest.getProductCode());
                    productData.setProductCategory(productRequest.getProductCategory());
                    productData.setPrice(productRequest.getPrice());
                    productData.setCreatedAt(productData.getCreatedAt());
                    productData.setUpdatedAt(LocalDateTime.now());
                    Product producSaved = productRepository.save(productData);
                    return new ProductResponse(
                            producSaved.getId(),
                            producSaved.getProductName(),
                            producSaved.getProductCode(),
                            producSaved.getProductCategory(),
                            producSaved.getPrice(),
                            producSaved.getCreatedAt(),
                            producSaved.getUpdatedAt()
                    );
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, PRODUCT_NOT_FOUND_MESSAGE + id));
    }

    public void deleteById(UUID id) {
        if (productRepository.existsById(id)){
            productRepository.deleteById(id);
        } else {
            log.warn(PRODUCT_NOT_FOUND_MESSAGE, id);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, PRODUCT_NOT_FOUND_MESSAGE + id);
        }
    }


}
