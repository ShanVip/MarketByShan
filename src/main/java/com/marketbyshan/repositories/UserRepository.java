package com.marketbyshan.repositories;

import com.marketbyshan.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);

    User findByUsername(String username);
    boolean existsByUsernameOrEmail(String username, String email);

}