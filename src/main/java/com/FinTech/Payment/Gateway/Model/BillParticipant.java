package com.FinTech.Payment.Gateway.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "BillParticipant")
public class BillParticipant {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private UUID billId;
    private UUID userId;
    private double amountOwed;
    private boolean isPaid;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // Custom setter for isPaid field
    public void setIsPaid(boolean isPaid) {
        this.isPaid = isPaid;
    }
}
