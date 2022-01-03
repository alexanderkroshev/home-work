package com.sbrf.reboot.service;

import com.sbrf.reboot.repository.AccountRepository;
import lombok.RequiredArgsConstructor;

import java.util.Set;

@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;


    public boolean isClientHasContract(long clientId, long contractNumber) {
        Set<Long> accounts = accountRepository.getAllAccountsByClientId(clientId);
        return accounts.contains(contractNumber);
    }

    public void deleteAccountFromClient(long clientId, long contractNumber) {
        Set<Long> accounts = accountRepository.getAllAccountsByClientId(clientId);
        accounts.remove(contractNumber);
        accountRepository.updateClient(clientId, accounts);
    }


}
