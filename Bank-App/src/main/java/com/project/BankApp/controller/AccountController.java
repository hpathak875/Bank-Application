package com.project.BankApp.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.BankApp.entity.Account;
import com.project.BankApp.entity.Log;
import com.project.BankApp.service.AccountService;

@RestController
@RequestMapping("/bank")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @Autowired
    private LogController logController;

    //URL:localhost:8080/bank/acctOpen
    @PostMapping("/acctOpen")
    public String createAccount(@RequestBody Account account) {
        accountService.createAccount(account);
        return "Account Created Successfully!!";
    }

    //localhost:8080/bank/acct/{id}
    @GetMapping("/acct/{id}")
    public Account getAccount(@PathVariable Long id) {
        return accountService.getAccount(id).orElseThrow(() -> new RuntimeException("Account not exist"));
    }
    
    //localhost:8080/bank/deposit/{id}
    @PostMapping("/deposit/{id}")
    public String deposit(@PathVariable Long id, @RequestBody Map<String, Integer> request) {
        int amount = request.get("INR");
        return accountService.deposit(id, amount);
    }

    //localhost:8080/bank/withdraw/{id}
    @PostMapping("/withdraw/{id}")
    public String withdraw(@PathVariable Long id, @RequestBody Map<String, Integer> request) {
        int amount = request.get("INR");
        return accountService.withdraw(id, amount);
    }

    //localhost:8080/bank/acctClose/{id}
    @DeleteMapping("/acctClose/{id}")
    public String deleteAccount(@PathVariable Long id){
        accountService.deleteAccount(id);
        logController.deleteLog(id);
        return "Account Deleted Successfully!!";
    }

    //localhost:8080/bank/balance/{id}
    @GetMapping("/balance/{id}")
    public String getBalance(@PathVariable Long id){
        String bal=accountService.getBalance(id);
        return "Balance for this account "+bal;
    }

    //localhost:8080/bank/transfer/{sId}/to/{dId}/{amount}
    @PutMapping("/transfer/{sourceId}/to/{destId}/{amount}")
    public String transferAmount(@PathVariable Long sourceId,@PathVariable Long destId,@PathVariable int amount){
        String sourceBal=getBalance(sourceId);
        String receiverBal=getBalance(destId);
        int sBal=Integer.parseInt(sourceBal);
        accountService.transferAmt(sourceId,destId,amount);
        String newSBal=getBalance(sourceId);
        String newRBal=getBalance(destId);
        Log logSender = new Log(sourceId, "Transferred", "Success", sBal, sBal - amount);
        logController.addLog(logSender);
        Log loggerReceiver = new Log(destId, "Received", "Success", sBal,
                sBal + amount);
        logController.addLog(loggerReceiver);
        return "Previous Bal for sourceAcct "+sourceBal+"\n"+
                "Previous Bal for receiver Acct "+receiverBal+
                "\n"+"Updated Balance for Source Acct "+newSBal+
                "\n"+"Updated Balance for Receiver Bal "+newRBal;
    }
}

