package com.project.BankApp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.BankApp.entity.Account;

import jakarta.transaction.Transactional;

@Repository
public interface AccountDAO extends CrudRepository<Account, Long>, JpaRepository<Account,Long> {

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("update Account set balance = balance+?2 where id=?1")
    public void saveBalanceByID(Long id, double amount);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("update Account set balance = balance-?2 where id=?1")
    public void withdrawAmountByID(Long id, double amount);
}
