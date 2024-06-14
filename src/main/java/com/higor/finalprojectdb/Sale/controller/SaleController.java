package com.higor.finalprojectdb.Sale.controller;

import com.higor.finalprojectdb.Sale.dto.SaleRequest;
import com.higor.finalprojectdb.Sale.dto.SaleResponse;
import com.higor.finalprojectdb.Sale.model.Sale;
import com.higor.finalprojectdb.Sale.service.SaleService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Log4j2
@RestController
@RequestMapping("/sales")
public class SaleController {

    @Autowired
    SaleService saleService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SaleResponse create(@RequestBody SaleRequest saleRequest){
        log.info("Receiving request for resource in productRequest={}", saleRequest);
        return saleService.create(saleRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<SaleResponse> findAll(){
        log.info("Receiving request for resource in findAll");
        return saleService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public SaleResponse findById(@PathVariable UUID id){
        log.info("Receiving request for resource in findById with: id={}", id);
        return saleService.findById(id);
    }

    @GetMapping("/listPaymentForType/{type}")
    @ResponseStatus(HttpStatus.OK)
    public List<Sale> getSalesForType(@PathVariable String type){
        log.info("Receiving request for resource in getStatistic");
        return saleService.listSalePaymentType(type);
    }

    @GetMapping("/totalBase")
    @ResponseStatus(HttpStatus.OK)
    public Object getTotalSales(){
        log.info("Receiving request for resource in getStatistic");
        return saleService.findTotalBase();
    }

    @GetMapping("/salesForUser/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public List<Sale> getSalesForUser(@PathVariable UUID userId){
        log.info("Receiving request for resource in getStatistic");
        return saleService.salesForUser(userId);
    }


}
