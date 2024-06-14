package com.higor.finalprojectdb.User.controller;

import com.higor.finalprojectdb.User.dto.UserRequest;
import com.higor.finalprojectdb.User.dto.UserResponse;
import com.higor.finalprojectdb.User.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Log4j2
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponse create(@RequestBody UserRequest userRequest){
        log.info("Receiving request for resource in userRequest={}", userRequest);
        return userService.create(userRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<UserResponse> findAll(){
        log.info("Receiving request for resource in findAll");
        return userService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserResponse findById(@PathVariable UUID id){
        log.info("Receiving request for resource in findById with: id={}", id);
        return userService.findById(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserResponse update(@PathVariable UUID id, @RequestBody UserRequest productRequest){
        log.info("Receiving request for resource in update with: id={} and Body={}", id, productRequest);
        return userService.update(id, productRequest);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable UUID id){
        log.info("Receiving request for resource in deleteById with: id={}", id);
        userService.deleteById(id);
    }
}
