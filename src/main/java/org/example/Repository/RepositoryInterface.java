package org.example.Repository;

import org.example.Model.Account;

public interface RepositoryInterface {
    void addAccount(Account account);
    Account getAccount(int id);
}
