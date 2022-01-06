package com.sbrf.reboot.repository.impl;

import com.sbrf.reboot.AccountRepository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class FileAccountRepository implements AccountRepository {

    private final String filePath;

    public FileAccountRepository(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public Set<Long> getAllAccountsByClientId(long clientId) throws IOException {
        HashMap<Long, HashSet<Long>> clients = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader((filePath)))) {
            String line;

            long number;
            HashSet<Long> numbers;

            while ((line = reader.readLine()) != null) {
                if (line.contains("clientId")) {
                    clientId = Integer.parseInt(line.replaceAll("[^0-9]", ""));
                    number = Integer.parseInt(reader.readLine().replaceAll("[^0-9]", ""));
                    if (clients.containsKey(clientId))
                        clients.get(clientId).add(number);
                    else {
                        numbers = new HashSet<>();
                        numbers.add(number);
                        clients.put(clientId, numbers);
                    }
                }
            }
        }
        return clients.get(clientId);


    }
}
