package com.bank.loan.service;

import com.bank.loan.model.Loan;
import com.bank.loan.repository.LoanRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import java.util.List;

@Service
public class LoanService {

    private final LoanRepository repository;
    private final WebClient webClient;

    public LoanService(LoanRepository repository, WebClient.Builder webClientBuilder) {
        this.repository = repository;
        this.webClient = webClientBuilder.baseUrl("http://localhost:8081").build();
    }

    public Loan createLoan(Loan loan) {
        // Verify account exists before creating loan
        webClient.get()
                .uri("/api/accounts/{id}", loan.getAccountId())
                .retrieve()
                .bodyToMono(Object.class)
                .block();
        return repository.save(loan);
    }

    public Loan getLoanById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Loan not found with id: " + id));
    }

    public List<Loan> getAllLoans() {
        return repository.findAll();
    }

    public List<Loan> getLoansByAccountId(Long accountId) {
        return repository.findByAccountId(accountId);
    }

    public Loan updateLoanStatus(Long id, String status) {
        Loan loan = getLoanById(id);
        loan.setStatus(status);
        return repository.save(loan);
    }

    public void deleteLoan(Long id) {
        repository.deleteById(id);
    }
}
