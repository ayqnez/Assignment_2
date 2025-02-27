package org.example.Service;

import org.example.Model.Account;
import org.example.Repository.RepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service("secure")
@Lazy
public class SecureBankingService implements ServiceInterface {
    private final RepositoryInterface repository;

    @Autowired
    public SecureBankingService(@Qualifier("backupRepo") RepositoryInterface repository) {
        this.repository = repository;
    }

    @Override
    public void deposit(int id, double amount) {
        Account account = repository.getAccount(id);
        if (account != null) {
            System.out.println("🔒 Performing additional security checks before deposit...");
            account.deposit(amount);
            System.out.println("💰 Deposited " + amount + " to account with id: " + id + " securely ✅");
        }
    }

    @Override
    public boolean withdraw(int id, double amount) {
        Account account = repository.getAccount(id);
        if (account != null) {
            System.out.println("🔒 Performing additional security checks before withdraw...");
            account.withdraw(amount);
            System.out.println("💸 Withdrawn " + amount + " from account with id: " + id + " securely ✅");
            return true;
        } else {
            System.out.println("❌ Withdrawal failed for account with id: " + id + " ⚠️");
            return false;
        }
    }
}
