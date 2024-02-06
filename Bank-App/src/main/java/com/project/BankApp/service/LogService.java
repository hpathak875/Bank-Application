package com.project.BankApp.service;

import com.project.BankApp.entity.Log;

public interface LogService {
    public void addLog(Log log);
    public Log showLog(Long id);
    public void removeLog(Long id);

}
