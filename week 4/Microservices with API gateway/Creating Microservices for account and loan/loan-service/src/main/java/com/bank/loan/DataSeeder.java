package com.bank.loan;

import com.bank.loan.model.Loan;
import com.bank.loan.repository.LoanRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataSeeder implements CommandLineRunner {

    private final LoanRepository repository;

    public DataSeeder(LoanRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) {
        repository.save(new Loan(1L, "HOME", 250000.00, 3.5, "ACTIVE"));
        repository.save(new Loan(2L, "CAR", 15000.00, 5.0, "ACTIVE"));
        repository.save(new Loan(1L, "PERSONAL", 5000.00, 7.5, "PENDING"));
    }
}
