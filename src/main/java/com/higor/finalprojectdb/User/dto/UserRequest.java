package com.higor.finalprojectdb.User.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest{

    private String name;
    private String email;
    private String telefone;
    private String cpf;
}
