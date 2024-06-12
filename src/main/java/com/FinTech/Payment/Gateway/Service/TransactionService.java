package com.FinTech.Payment.Gateway.Service;

import com.FinTech.Payment.Gateway.Model.Transaction;
import com.FinTech.Payment.Gateway.Repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    public Transaction getTransactionById(UUID id) {
        return transactionRepository.findById(id).orElse(null);
    }

    public Transaction createTransaction(Transaction transaction) {
        transaction.setId(UUID.randomUUID());
        transaction.setTransactionDate(LocalDateTime.now());
        transaction.setCreatedAt(LocalDateTime.now());
        transaction.setUpdatedAt(LocalDateTime.now());
        return transactionRepository.save(transaction);
    }

    public Transaction updateTransaction(UUID id, Transaction transaction) {
        Transaction existingTransaction = transactionRepository.findById(id).orElse(null);
        if (existingTransaction != null) {
            existingTransaction.setBillId(transaction.getBillId());
            existingTransaction.setPayerId(transaction.getPayerId());
            existingTransaction.setPayeeId(transaction.getPayeeId());
            existingTransaction.setAmount(transaction.getAmount());
            existingTransaction.setUpdatedAt(LocalDateTime.now());
            return transactionRepository.save(existingTransaction);
        } else {
            return null;
        }
    }

    public void deleteTransaction(UUID id) {
        transactionRepository.deleteById(id);
    }
}
