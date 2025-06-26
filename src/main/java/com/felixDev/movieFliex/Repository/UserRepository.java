package com.felixDev.movieFliex.Repository;

import com.felixDev.movieFliex.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {

    Optional<UserDetails> findByEmail(String email);
}
