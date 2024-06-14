package com.higor.finalprojectdb.User.service;

import com.higor.finalprojectdb.User.dto.UserRequest;
import com.higor.finalprojectdb.User.dto.UserResponse;
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
public class UserService {

    @Autowired
    UserRepository userRepository;

    public UserResponse create(UserRequest userRequest) {

        User user = userRepository.save(new User(
                UUID.randomUUID(),
                userRequest.getName(),
                userRequest.getEmail(),
                userRequest.getTelefone(),
                userRequest.getCpf(),
                LocalDateTime.now(),
                null
        ));
        return new UserResponse(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user. getTelefone(),
                user.getCpf(),
                user.getCreatedAt(),
                user.getUpdatedAt()
        );
    }

    public List<UserResponse> findAll() {
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

    public UserResponse findById(UUID id) {
        return userRepository.findById(id)
                .map(user -> new UserResponse(
                        user.getId(),
                        user.getName(),
                        user.getEmail(),
                        user.getTelefone(),
                        user.getCpf(),
                        user.getCreatedAt(),
                        user.getUpdatedAt()
                )).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found with id: " + id));
    }

    public UserResponse update(UUID id, UserRequest userRequest) {

        return userRepository.findById(id)
                .map(user -> {
                    user.setName(userRequest.getName());
                    user.setEmail(userRequest.getEmail());
                    user.setTelefone(userRequest.getTelefone());
                    user.setCpf(userRequest.getCpf());
                    user.setCreatedAt(user.getCreatedAt());
                    LocalDateTime.now();
                    userRepository.save(user);
                    return new UserResponse(
                            user.getId(),
                            user.getName(),
                            user.getEmail(),
                            user.getTelefone(),
                            user.getCpf(),
                            user.getCreatedAt(),
                            user.getUpdatedAt()
                    );
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found with id: " + id));
    }

    public void deleteById(UUID id) {

        if (userRepository.existsById(id)){
            userRepository.deleteById(id);
        } else {
            log.warn("User not found with id: {}", id);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found with id: " + id);
        }
    }
}
