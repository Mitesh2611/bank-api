package com.example.bankingapi.service;

import com.example.bankingapi.dto.AccountDTO;
import com.example.bankingapi.entity.Account;

import java.util.List;

public interface AccountService {
    AccountDTO createAccount(AccountDTO accountDTO);

    AccountDTO getAccountById(Long id);

    AccountDTO deposit(Long id, double amount);

    AccountDTO withdraw(Long id, double amount);

    List<AccountDTO> getAlAccounts();

    void deleteAccount(Long id);
}
