package com.higor.finalprojectdb.Product.controller;

import com.higor.finalprojectdb.Product.dto.ProductRequest;
import com.higor.finalprojectdb.Product.dto.ProductResponse;
import com.higor.finalprojectdb.Product.service.ProductService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Log4j2
@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductResponse create(@RequestBody ProductRequest productRequest){
        log.info("Receiving request for resource in productRequest={}", productRequest);
        return productService.create(productRequest);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProductResponse findById(@PathVariable UUID id){
        log.info("Receiving request for resource in findById with: id={}", id);
        return productService.findById(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProductResponse update(@PathVariable UUID id, @RequestBody ProductRequest productRequest){
        log.info("Receiving request for resource in update with: id={} and Body={}", id, productRequest);
        return productService.update(id, productRequest);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable UUID id){
        log.info("Receiving request for resource in deleteById with: id={}", id);
        productService.deleteById(id);
    }
}
