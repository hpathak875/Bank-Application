package com.project.BankApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.BankApp.entity.Log;
import com.project.BankApp.service.LogService;

@RestController
@RequestMapping("/log")
public class LogController {
    @Autowired
    private LogService logService;

    public void addLog(Log log){
        logService.addLog(log);
    }

    @GetMapping("/showlog/{id}")
    public Log showlog(@PathVariable Long id){
        return logService.showLog(id);
    }

    public void deleteLog(Long id){
        logService.removeLog(id);
    }

}
