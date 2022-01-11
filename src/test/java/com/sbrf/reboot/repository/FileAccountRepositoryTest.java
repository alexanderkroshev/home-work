package com.sbrf.reboot.repository;

import com.sbrf.reboot.AccountRepository;
import com.sbrf.reboot.repository.impl.FileAccountRepository;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertTrue;

class FileAccountRepositoryTest {

    AccountRepository accountRepository;


    @Test
    void onlyPersonalAccounts() {
        String filePath = "src/main/resources/Accounts.txt";
        accountRepository = new FileAccountRepository(filePath);
        long clientId = 1L;
        Set<Long> actualAccounts = accountRepository.getAllAccountsByClientId(clientId);
        Set<Long> expected = new HashSet<Long>() {{
            add(111L);
            add(222L);
            add(333L);
        }};
        actualAccounts.forEach(e -> assertTrue(expected.contains(e)));
    }

    @Test
    void updateNumberByClientId() {
        String filePath = "src/main/resources/Accounts.txt";
        FileAccountRepository repository = new FileAccountRepository(filePath);
        long clientId = 1L;
        repository.updateNumberByClientId(clientId, 333L, 444L);
        Set<Long> accounts = repository.getAllAccountsByClientId(clientId);

        Set<Long> expected = new HashSet<Long>() {{
            add(111L);
            add(222L);
            add(444L);
        }};
        accounts.forEach(e -> assertTrue(expected.contains(e)));
        repository.updateNumberByClientId(clientId, 444L, 333L);
    }

}