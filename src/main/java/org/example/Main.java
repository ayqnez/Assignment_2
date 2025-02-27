package org.example;

import org.example.Model.Account;
import org.example.Repository.AccountRepository;
import org.example.Repository.BackupAccountRepository;
import org.example.Service.ServiceInterface;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        // Models
        Account account1 = new Account(1, 550);
        Account account2 = new Account(2, 800);
        Account account3 = new Account(3, 1200);

        Account account4 = new Account(1, 300);
        Account account5 = new Account(2, 500);

        AccountRepository accountRepository = context.getBean(AccountRepository.class);
        accountRepository.addAccount(account1);
        accountRepository.addAccount(account2);
        accountRepository.addAccount(account3);

        BackupAccountRepository backupAccountRepository = context.getBean(BackupAccountRepository.class);
        backupAccountRepository.addAccount(account4);
        backupAccountRepository.addAccount(account5);

        System.out.println("--- Primary service ---");

        ServiceInterface service = context.getBean(ServiceInterface.class);
        service.deposit(1, 50);
        System.out.println(account1.getBalance());
        service.withdraw(1, 200);
        System.out.println(account1.getBalance());

        System.out.println("--- Secondary service ---");

        ServiceInterface service2 = context.getBean("secure", ServiceInterface.class);
        service2.deposit(2, 300);
        System.out.println(account5.getBalance());
        service2.withdraw(2, 200);
        System.out.println(account5.getBalance());
    }
}