package com.FinTech.Payment.Gateway.Repository;

import com.FinTech.Payment.Gateway.Model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface TransactionRepository extends JpaRepository<Transaction, UUID> {
}

