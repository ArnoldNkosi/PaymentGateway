package com.FinTech.Payment.Gateway.Repository;

import com.FinTech.Payment.Gateway.Model.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface BillRepository extends JpaRepository<Bill, UUID> {
}

