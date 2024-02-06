package com.project.BankApp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.BankApp.entity.Log;

public interface LogDAO extends JpaRepository<Log,Long> {
}
