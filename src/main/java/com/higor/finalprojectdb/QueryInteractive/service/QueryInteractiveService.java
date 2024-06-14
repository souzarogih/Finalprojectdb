package com.higor.finalprojectdb.QueryInteractive.service;

import com.higor.finalprojectdb.Product.dto.ProductResponse;
import com.higor.finalprojectdb.Product.model.Product;
import com.higor.finalprojectdb.Product.repository.ProductRepository;
import com.higor.finalprojectdb.Sale.dto.SaleResponse;
import com.higor.finalprojectdb.Sale.model.Sale;
import com.higor.finalprojectdb.Sale.repository.SaleRepository;
import com.higor.finalprojectdb.User.dto.UserResponse;
import com.higor.finalprojectdb.User.model.User;
import com.higor.finalprojectdb.User.repository.UserRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import java.util.stream.Collectors;

@Log4j2
@Service
public class QueryInteractiveService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    SaleRepository saleRepository;

    @Autowired
    UserRepository userRepository;


    public List<ProductResponse> findAllProducts() {
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

    public List<Object> findProductByField(String field) {
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

    public List<SaleResponse> findAllSales() {
        return saleRepository.findAll().stream()
                .map(sale -> new SaleResponse(
                        sale.getId(),
                        sale.getProductId(),
                        null,
                        sale.getPaymentType(),
                        sale.getSaleDate(),
                        sale.getInstallments(),
                        sale.getSalesValue(),
                        sale.getEstimatedDeliveryDate(),
                        sale.getDeliveryDate(),
                        sale.getCreatedAt()
                )).collect(Collectors.toList());
    }

    public List<Object> findSaleByField(String field) {
        log.info("findSaleByField {}", field);

        switch (field){

            case "id":
                return saleRepository.findAll().stream().map(Sale::getId).collect(Collectors.toList());

            case "product_id":
                return saleRepository.findAll().stream().map(Sale::getProductId).collect(Collectors.toList());

            case "payment_type":
                return saleRepository.findAll().stream().map(Sale::getPaymentType).collect(Collectors.toList());

            case "sale_date":
                return saleRepository.findAll().stream().map(Sale::getSaleDate).collect(Collectors.toList());

            case "installments":
                return saleRepository.findAll().stream().map(Sale::getInstallments).collect(Collectors.toList());

            case "sales_value":
                return saleRepository.findAll().stream().map(Sale::getSalesValue).collect(Collectors.toList());

            case "estimated_delivery_date":
                return saleRepository.findAll().stream().map(Sale::getEstimatedDeliveryDate).collect(Collectors.toList());

            case "delivery_date":
                return saleRepository.findAll().stream().map(Sale::getDeliveryDate).collect(Collectors.toList());

            case "created_at":
                return saleRepository.findAll().stream().map(Sale::getCreatedAt).collect(Collectors.toList());

            default:
                return null;

        }
    }

    public List<UserResponse> findAllUsers() {
        return userRepository.findAll().stream()
                .map(user -> new UserResponse(
                        user.getId(),
                        user.getName(),
                        user.getEmail(),
                        user.getTelefone(),
                        user.getCpf(),
                        user.getCreatedAt(),
                        user.getUpdatedAt()
                )).collect(Collectors.toList());
    }

    public List<Object> findUserByField(String field) {
        log.info("findUserByField {}", field);

        switch (field){

            case "id":
                return userRepository.findAll().stream().map(User::getId).collect(Collectors.toList());

            case "name":
                return userRepository.findAll().stream().map(User::getName).collect(Collectors.toList());

            case "email":
                return userRepository.findAll().stream().map(User::getEmail).collect(Collectors.toList());

            case "telefone":
                return userRepository.findAll().stream().map(User::getTelefone).collect(Collectors.toList());

            case "cpf":
                return userRepository.findAll().stream().map(User::getCpf).collect(Collectors.toList());

            case "created_at":
                return userRepository.findAll().stream().map(User::getCreatedAt).collect(Collectors.toList());

            case "updated_at":
                return userRepository.findAll().stream().map(User::getUpdatedAt).collect(Collectors.toList());

            default:
                return null;

        }
    }




}
