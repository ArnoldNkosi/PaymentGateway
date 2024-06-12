package com.FinTech.Payment.Gateway.Controller;

import com.FinTech.Payment.Gateway.Model.BillParticipant;
import com.FinTech.Payment.Gateway.Service.BillParticipantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/bill-participants")
public class BillParticipantController {

    @Autowired
    private BillParticipantService billParticipantService;

    @GetMapping
    public List<BillParticipant> getAllBillParticipants() {
        return billParticipantService.getAllBillParticipants();
    }

    @GetMapping("/{id}")
    public BillParticipant getBillParticipantById(@PathVariable UUID id) {
        return billParticipantService.getBillParticipantById(id);
    }

    @PostMapping
    public BillParticipant createBillParticipant(@RequestBody BillParticipant billParticipant) {
        return billParticipantService.createBillParticipant(billParticipant);
    }

    @PutMapping("/{id}")
    public BillParticipant updateBillParticipant(@PathVariable UUID id, @RequestBody BillParticipant billParticipant) {
        return billParticipantService.updateBillParticipant(id, billParticipant);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBillParticipant(@PathVariable UUID id) {
        billParticipantService.deleteBillParticipant(id);
        return ResponseEntity.noContent().build();
    }
}
