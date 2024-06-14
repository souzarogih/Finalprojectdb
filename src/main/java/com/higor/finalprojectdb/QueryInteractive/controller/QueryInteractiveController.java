package com.higor.finalprojectdb.QueryInteractive.controller;

import com.higor.finalprojectdb.Product.dto.ProductResponse;
import com.higor.finalprojectdb.QueryInteractive.service.QueryInteractiveService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Log4j2
@RestController
@RequestMapping("/productQuery")
public class QueryInteractiveController {

    @Autowired
    QueryInteractiveService queryInteractiveService;

    @GetMapping("/{field}")
    @ResponseStatus(HttpStatus.OK)
    public List<Object> findField(@PathVariable String field){
        log.info("Receiving request for resource in findField with: field={}", field);
        return queryInteractiveService.findByField(field);
    }
}
