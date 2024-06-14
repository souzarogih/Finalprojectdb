package com.higor.finalprojectdb.User.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {

    private UUID id;
    private String name;
    private String email;
    private String telefone;
    private String cpf;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
