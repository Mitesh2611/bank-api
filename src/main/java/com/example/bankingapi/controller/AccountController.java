package com.example.bankingapi.controller;

import com.example.bankingapi.dto.AccountDTO;
import com.example.bankingapi.entity.Account;
import com.example.bankingapi.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    private AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/create")
    public ResponseEntity<AccountDTO> addAccount(@RequestBody AccountDTO accountDTO){
        return new ResponseEntity<>(accountService.createAccount(accountDTO), HttpStatus.CREATED);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<AccountDTO> getAccountById(@PathVariable Long id){
        AccountDTO accountDTO = accountService.getAccountById(id);
        return ResponseEntity.ok(accountDTO);
    }

    @PutMapping("/deposit/{id}")
    public ResponseEntity<AccountDTO> deposit(@PathVariable Long id, @RequestBody Map<String, Double> request){
        Double amount = request.get("amount");
        AccountDTO accountDTO = accountService.deposit(id, amount);
        return ResponseEntity.ok(accountDTO);
    }

    @PutMapping("/withdraw/{id}")
    public ResponseEntity<AccountDTO> withdraw(@PathVariable Long id, @RequestBody Map<String, Double> request){
        Double amount = request.get("amount");
        AccountDTO accountDTO = accountService.withdraw(id, amount);
        return ResponseEntity.ok(accountDTO);
    }

    @GetMapping("/all")
    public ResponseEntity<List<AccountDTO>> getAllAccounts(){
        List<AccountDTO> accountDTOS = accountService.getAlAccounts();
        return ResponseEntity.ok(accountDTOS);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteAccount(@PathVariable Long id){
        accountService.deleteAccount(id);
        return ResponseEntity.ok("Account: "+ id + " is deleted..!");
    }
}
