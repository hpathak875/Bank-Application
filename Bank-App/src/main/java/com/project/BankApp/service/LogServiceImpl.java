package com.project.BankApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.BankApp.dao.LogDAO;
import com.project.BankApp.entity.Log;

@Service
public class LogServiceImpl implements LogService{

    @Autowired
    LogDAO logDao;
    @Override
    public void addLog(Log log) {
        logDao.save(log);
    }

    @Override
    public Log showLog(Long id) {
        return logDao.findById(id).orElse(null);
    }

    @Override
    public void removeLog(Long id) {
        logDao.deleteById(id);
    }
}

