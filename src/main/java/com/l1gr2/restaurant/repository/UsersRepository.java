package com.l1gr2.restaurant.repository;

import com.l1gr2.restaurant.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, String> {
}
