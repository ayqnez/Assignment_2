package org.example.Service;

import org.example.Model.Account;
import org.example.Repository.RepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class SimpleBankingService implements ServiceInterface {
    private final RepositoryInterface repository;

    @Autowired
    public SimpleBankingService(RepositoryInterface repository) {
        this.repository = repository;
    }

    @Override
    public void deposit(int id, double amount) {
        Account account = repository.getAccount(id);
        if (account != null) {
            account.deposit(amount);
            System.out.println("Deposited " + amount + " to account with id: " + id);
        }
    }

    @Override
    public boolean withdraw(int id, double amount) {
        Account account = repository.getAccount(id);
        if (account != null) {
            account.withdraw(amount);
            System.out.println("Withdrew " + amount + " from account with id: " + id);
            return true;
        } else {
            System.out.println("Withdrawal failed for account with id: " + id);
            return false;
        }
    }
}
