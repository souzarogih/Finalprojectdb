package com.higor.finalprojectdb.User.repository;

import com.higor.finalprojectdb.User.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

    @Query(value = "SELECT count(u.*) FROM users u", nativeQuery = true)
    Integer findTotalUsers();
}
