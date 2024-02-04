package com.example.flight.repository;

import com.example.flight.model.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;

public interface UserRepository extends JpaRepository<UserInfo,Long> {

    Optional<UserInfo> findByName(String username);

}
