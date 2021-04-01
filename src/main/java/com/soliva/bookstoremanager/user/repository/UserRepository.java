package com.soliva.bookstoremanager.user.repository;

import com.soliva.bookstoremanager.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
