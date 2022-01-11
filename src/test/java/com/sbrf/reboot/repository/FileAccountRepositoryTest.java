package com.sbrf.reboot.repository;

import com.sbrf.reboot.repository.impl.FileAccountRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FileAccountRepositoryTest {

    String filePath = "src/main/resources/Accounts.txt";
    FileAccountRepository accountRepository = new FileAccountRepository(filePath);

    @AfterEach
    public void makeInitial() {
        accountRepository.updateAccountByClientId(1L, 444L, 333L);
    }

    @Test
    void onlyPersonalAccounts() {
        long clientId = 1L;
        Set<Long> actualAccounts = accountRepository.getAllAccountsByClientId(clientId);
        Set<Long> expected = new HashSet<Long>() {{
            add(111L);
            add(222L);
            add(333L);
        }};

        assertEquals(expected, actualAccounts);
    }

    @Test
    void updateAccountByClientId() {
        String filePath = "src/main/resources/Accounts.txt";
        FileAccountRepository accountRepository = new FileAccountRepository(filePath);
        long clientId = 1L;
        accountRepository.updateAccountByClientId(clientId, 333L, 444L);
        Set<Long> actualAccounts = accountRepository.getAllAccountsByClientId(clientId);

        Set<Long> expected = new HashSet<Long>() {{
            add(111L);
            add(222L);
            add(444L);
        }};

        assertEquals(expected, actualAccounts);
    }

}