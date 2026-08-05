package com.bank.loan.controller;

import com.bank.loan.model.Loan;
import com.bank.loan.service.LoanService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/loans")
public class LoanController {

    private final LoanService service;

    public LoanController(LoanService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Loan> createLoan(@Valid @RequestBody Loan loan) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createLoan(loan));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Loan> getLoan(@PathVariable Long id) {
        return ResponseEntity.ok(service.getLoanById(id));
    }

    @GetMapping
    public ResponseEntity<List<Loan>> getAllLoans() {
        return ResponseEntity.ok(service.getAllLoans());
    }

    @GetMapping("/account/{accountId}")
    public ResponseEntity<List<Loan>> getLoansByAccount(@PathVariable Long accountId) {
        return ResponseEntity.ok(service.getLoansByAccountId(accountId));
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<Loan> updateStatus(@PathVariable Long id, @RequestParam String status) {
        return ResponseEntity.ok(service.updateLoanStatus(id, status));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLoan(@PathVariable Long id) {
        service.deleteLoan(id);
        return ResponseEntity.noContent().build();
    }
}
