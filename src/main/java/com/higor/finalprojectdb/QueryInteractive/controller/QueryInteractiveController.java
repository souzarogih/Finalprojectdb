package com.higor.finalprojectdb.QueryInteractive.controller;

import com.higor.finalprojectdb.Product.dto.ProductResponse;
import com.higor.finalprojectdb.QueryInteractive.service.QueryInteractiveService;
import com.higor.finalprojectdb.Sale.dto.SaleResponse;
import com.higor.finalprojectdb.User.dto.UserResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Log4j2
@RestController
@RequestMapping("/query")
public class QueryInteractiveController {

    @Autowired
    QueryInteractiveService queryInteractiveService;

    @GetMapping("/product/{field}")
    @ResponseStatus(HttpStatus.OK)
    public List<Object> findProductByField(@PathVariable String field){
        log.info("Receiving request for resource in findField with: field={}", field);
        return queryInteractiveService.findProductByField(field);
    }

    @GetMapping("/product/all")
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> findAllProducts(){
        log.info("Receiving request for resource in findAllProducts with");
        return queryInteractiveService.findAllProducts();
    }

    @GetMapping("/sale/{field}")
    @ResponseStatus(HttpStatus.OK)
    public List<Object> findFieldSale(@PathVariable String field){
        log.info("Receiving request for resource in findFieldSale with: field={}", field);
        return queryInteractiveService.findSaleByField(field);
    }

    @GetMapping("/sale/all")
    @ResponseStatus(HttpStatus.OK)
    public List<SaleResponse> findAllSales(){
        log.info("Receiving request for resource in findAllSales with");
        return queryInteractiveService.findAllSales();
    }

    @GetMapping("/user/{field}")
    @ResponseStatus(HttpStatus.OK)
    public List<Object> findFieldUser(@PathVariable String field){
        log.info("Receiving request for resource in findFieldUser with: field={}", field);
        return queryInteractiveService.findUserByField(field);
    }

    @GetMapping("/user/all")
    @ResponseStatus(HttpStatus.OK)
    public List<UserResponse> findAllUsers(){
        log.info("Receiving request for resource in findAllUsers with");
        return queryInteractiveService.findAllUsers();
    }
}
