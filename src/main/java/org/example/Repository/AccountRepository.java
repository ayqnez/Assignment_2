package org.example.Repository;

import org.example.Model.Account;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
@Primary
public class AccountRepository implements RepositoryInterface {
    private final Map<Integer, Account> accountMap = new HashMap<>();

    public AccountRepository() {
        System.out.println("You use AccountRepository");
    }

    @Override
    public void addAccount(Account account) {
        accountMap.put(account.getId(), account);
    }

    @Override
    public Account getAccount(int id) {
        return accountMap.get(id);
    }
}
