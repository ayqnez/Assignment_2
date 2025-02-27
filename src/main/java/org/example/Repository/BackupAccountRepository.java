package org.example.Repository;

import org.example.Model.Account;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
@Qualifier("backupRepo")
@Lazy
public class BackupAccountRepository implements RepositoryInterface {
    private final Map<Integer, Account> backupAccountMap = new HashMap<>();
    public BackupAccountRepository() {
        System.out.println("You use backupAccountRepository");
    }

    @Override
    public void addAccount(Account account) {
        backupAccountMap.put(account.getId(), account);
    }

    @Override
    public Account getAccount(int id) {
        return backupAccountMap.get(id);
    }
}
