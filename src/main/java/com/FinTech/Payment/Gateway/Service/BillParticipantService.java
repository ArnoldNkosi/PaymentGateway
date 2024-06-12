package com.FinTech.Payment.Gateway.Service;

import com.FinTech.Payment.Gateway.Model.BillParticipant;
import com.FinTech.Payment.Gateway.Repository.BillParticipantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class BillParticipantService {

    @Autowired
    private BillParticipantRepository billParticipantRepository;

    public List<BillParticipant> getAllBillParticipants() {
        return billParticipantRepository.findAll();
    }

    public BillParticipant getBillParticipantById(UUID id) {
        return billParticipantRepository.findById(id).orElse(null);
    }

    public BillParticipant createBillParticipant(BillParticipant billParticipant) {
        billParticipant.setId(UUID.randomUUID());
        billParticipant.setCreatedAt(LocalDateTime.now());
        billParticipant.setUpdatedAt(LocalDateTime.now());
        return billParticipantRepository.save(billParticipant);
    }

    public BillParticipant updateBillParticipant(UUID id, BillParticipant billParticipant) {
        BillParticipant existingBillParticipant = billParticipantRepository.findById(id).orElse(null);
        if (existingBillParticipant != null) {
            existingBillParticipant.setBillId(billParticipant.getBillId());
            existingBillParticipant.setUserId(billParticipant.getUserId());
            existingBillParticipant.setAmountOwed(billParticipant.getAmountOwed());
            existingBillParticipant.setIsPaid(billParticipant.isPaid());
            existingBillParticipant.setUpdatedAt(LocalDateTime.now());
            return billParticipantRepository.save(existingBillParticipant);
        } else {
            return null;
        }
    }

    public void deleteBillParticipant(UUID id) {
        billParticipantRepository.deleteById(id);
    }
}

