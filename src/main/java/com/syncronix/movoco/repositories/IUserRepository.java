package com.syncronix.movoco.repositories;

import com.syncronix.movoco.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {
        Optional<User> findByEmail(String email);

        Boolean existsByCode(String code);
        Boolean existsByEmail(String email);
}
