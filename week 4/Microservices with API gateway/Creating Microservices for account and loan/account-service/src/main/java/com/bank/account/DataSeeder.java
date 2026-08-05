package com.bank.account;

import com.bank.account.model.Account;
import com.bank.account.repository.AccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataSeeder implements CommandLineRunner {

    private final AccountRepository repository;

    public DataSeeder(AccountRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) {
        repository.save(new Account("ACC-001", "SAVINGS", 5000.00, "Alice Johnson"));
        repository.save(new Account("ACC-002", "CHECKING", 12000.00, "Bob Smith"));
        repository.save(new Account("ACC-003", "SAVINGS", 3500.00, "Carol White"));
    }
}
