package com.project.BankApp.service;

import java.util.Optional;

import com.project.BankApp.entity.Account;

public interface AccountService {
    public void createAccount(Account account);
    public Optional<Account> getAccount(Long id);
    public String deposit(Long id, int amount);
    public String withdraw(Long id, int amount);
    public void deleteAccount(Long id);
    public String getBalance(Long id);
    public void transferAmt(Long sourceId,Long destId, int amount);
}
