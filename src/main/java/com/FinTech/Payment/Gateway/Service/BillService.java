package com.FinTech.Payment.Gateway.Service;

import com.FinTech.Payment.Gateway.Model.Bill;
import com.FinTech.Payment.Gateway.Repository.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class BillService {

    @Autowired
    private BillRepository billRepository;

    public List<Bill> getAllBills() {
        return billRepository.findAll();
    }

    public Bill getBillById(UUID id) {
        return billRepository.findById(id).orElse(null);
    }

    public Bill createBill(Bill bill) {
        bill.setId(UUID.randomUUID());
        bill.setCreatedAt(LocalDateTime.now());
        bill.setUpdatedAt(LocalDateTime.now());
        return billRepository.save(bill);
    }

    public Bill updateBill(UUID id, Bill bill) {
        Bill existingBill = billRepository.findById(id).orElse(null);
        if (existingBill != null) {
            existingBill.setTotalAmount(bill.getTotalAmount());
            existingBill.setDescription(bill.getDescription());
            existingBill.setUpdatedAt(LocalDateTime.now());
            return billRepository.save(existingBill);
        } else {
            return null;
        }
    }

    public void deleteBill(UUID id) {
        billRepository.deleteById(id);
    }
}

