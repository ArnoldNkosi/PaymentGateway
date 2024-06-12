package com.FinTech.Payment.Gateway.Repository;

import com.FinTech.Payment.Gateway.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
}

