package com.steppedua.dropauto.repository;


import com.steppedua.dropauto.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
