package com.bank.account.service;

import com.bank.account.model.Account;
import com.bank.account.repository.AccountRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AccountService {

    private final AccountRepository repository;

    public AccountService(AccountRepository repository) {
        this.repository = repository;
    }

    public Account createAccount(Account account) {
        return repository.save(account);
    }

    public Account getAccountById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Account not found with id: " + id));
    }

    public List<Account> getAllAccounts() {
        return repository.findAll();
    }

    public Account updateAccount(Long id, Account updated) {
        Account existing = getAccountById(id);
        existing.setAccountType(updated.getAccountType());
        existing.setBalance(updated.getBalance());
        existing.setOwnerName(updated.getOwnerName());
        return repository.save(existing);
    }

    public void deleteAccount(Long id) {
        repository.deleteById(id);
    }
}
