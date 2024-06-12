package com.FinTech.Payment.Gateway.Model;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "bills")
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private double totalAmount;
    private String description;
    private UUID creatorId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
