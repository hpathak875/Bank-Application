package com.project.BankApp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.BankApp.dao.AccountDAO;
import com.project.BankApp.entity.Account;

@Service
public class AccountServiceImpl implements AccountService{

    @Autowired
    private AccountDAO accountDAO;
    @Override
    public void createAccount(Account account) {
        accountDAO.save(account);
    }

    @Override
    public Optional<Account> getAccount(Long id) {
        return accountDAO.findById(id);
    }

    @Override
    public String deposit(Long id, int amount) {
        Account account = getAccount(id).orElseThrow(() -> new RuntimeException("Account not exist"));
        account.setBalance(account.getBalance() + amount);
        accountDAO.save(account);
        return "Updated Balance for " + account.getAcctNo() + " is " + Double.toString(account.getBalance());
    }

    @Override
    public String withdraw(Long id, int amount) {
        Account account = getAccount(id).orElseThrow(() -> new RuntimeException("Account not exist"));
            if (account.getBalance() < amount) {
                throw new RuntimeException("Not Enough Funds");
            }
            account.setBalance(account.getBalance() - amount);
            accountDAO.save(account);
            return "Updated Balance for " + account.getAcctNo() + " is " + Double.toString(account.getBalance());
    }

    @Override
    public void deleteAccount(Long id) {
        accountDAO.deleteById(id);
    }

    @Override
    public String getBalance(Long id) {
        Account account = getAccount(id).orElseThrow(() -> new RuntimeException("Account not exist"));
            double bal = account.getBalance();
            return bal + " INR";
    }

    @Override
    public void transferAmt(Long sourceId, Long destId, int amount) {
            accountDAO.withdrawAmountByID(sourceId, amount);
            accountDAO.saveBalanceByID(destId, amount);


    }


}
