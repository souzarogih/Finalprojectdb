package com.higor.finalprojectdb.Sale.service;

import com.higor.finalprojectdb.Product.model.Product;
import com.higor.finalprojectdb.Product.repository.ProductRepository;
import com.higor.finalprojectdb.Sale.dto.SaleRequest;
import com.higor.finalprojectdb.Sale.dto.SaleResponse;
import com.higor.finalprojectdb.Sale.dto.TotalBaseDto;
import com.higor.finalprojectdb.Sale.model.Sale;
import com.higor.finalprojectdb.Sale.repository.SaleRepository;
import com.higor.finalprojectdb.User.model.User;
import com.higor.finalprojectdb.User.repository.UserRepository;
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
public class SaleService {

    @Autowired
    SaleRepository saleRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ProductRepository productRepository;

    public SaleResponse create(SaleRequest saleRequest) {

        Product productDB = productRepository.findById(saleRequest.getProductId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado"));

        User userDB = userRepository.findById(saleRequest.getUserId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado"));

        Sale sale = saleRepository.save(new Sale(
                UUID.randomUUID(),
                productDB,
                userDB,
                saleRequest.getPaymentType(),
                LocalDateTime.now(),
                saleRequest.getInstallments(),
                saleRequest.getSalesValue(),
                saleRequest.getEstimatedDeliveryDate(),
                saleRequest.getDeliveryDate(),
                LocalDateTime.now()
        ));
        return new SaleResponse(
                sale.getId(),
                sale.getProductId(),
                sale.getUserId(),
                sale.getPaymentType(),
                sale.getSaleDate(),
                sale.getInstallments(),
                sale.getSalesValue(),
                sale.getEstimatedDeliveryDate(),
                sale.getDeliveryDate(),
                sale.getCreatedAt()
        );
    }

    public List<SaleResponse> findAll() {
        return saleRepository.findAll().stream()
                .map(sale -> new SaleResponse(
                        sale.getId(),
                        sale.getProductId(),
                        sale.getUserId(),
                        sale.getPaymentType(),
                        sale.getSaleDate(),
                        sale.getInstallments(),
                        sale.getSalesValue(),
                        sale.getEstimatedDeliveryDate(),
                        sale.getDeliveryDate(),
                        sale.getCreatedAt()
                )).collect(Collectors.toList());
    }

    public SaleResponse findById(UUID id) {
        return saleRepository.findById(id)
                .map(sale -> new SaleResponse(
                        sale.getId(),
                        sale.getProductId(),
                        sale.getUserId(),
                        sale.getPaymentType(),
                        sale.getSaleDate(),
                        sale.getInstallments(),
                        sale.getSalesValue(),
                        sale.getEstimatedDeliveryDate(),
                        sale.getDeliveryDate(),
                        sale.getCreatedAt()
                )).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Sale not found with id: " + id));
    }

    public List<Sale> listSalePaymentType(String type) {
        List<Sale> sales = null;
        if (type.equals("PIX")){
            sales = saleRepository.listSalePaymentType("PIX");
        }else if(type.equals("CARD")){
            sales = saleRepository.listSalePaymentType("CARD");
        }else if(type.equals("CASH")){
            sales = saleRepository.listSalePaymentType("CASH");
        }
        return sales;
    }

    public Object findTotalBase() {
        Integer totalsale = saleRepository.findTotalSales();
        Integer totalproduct = productRepository.findTotalProducts();
        Integer totaluser = userRepository.findTotalUsers();

        String pixType = "PIX";
        Integer totalSalePixType = saleRepository.findTotalSalePaymentType(pixType);

        String cardType = "CARD";
        Integer totalSaleCardType = saleRepository.findTotalSalePaymentType(cardType);

        String cashType = "CASH";
        Integer totalSaleCashType = saleRepository.findTotalSalePaymentType(cashType);

        return new TotalBaseDto(
                totalsale,
                totalproduct,
                totaluser,
                totalSalePixType,
                totalSaleCardType,
                totalSaleCashType
        );
    }
}
