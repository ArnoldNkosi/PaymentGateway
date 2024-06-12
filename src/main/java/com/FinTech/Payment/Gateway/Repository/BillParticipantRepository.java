package com.FinTech.Payment.Gateway.Repository;

import com.FinTech.Payment.Gateway.Model.BillParticipant;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface BillParticipantRepository extends JpaRepository<BillParticipant, UUID> {
}
