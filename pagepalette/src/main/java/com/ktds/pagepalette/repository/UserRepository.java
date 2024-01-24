package com.ktds.pagepalette.repository;

import com.ktds.pagepalette.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
