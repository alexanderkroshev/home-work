package com.sbrf.reboot.repository.impl;

import com.sbrf.reboot.AccountRepository;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class FileAccountRepository implements AccountRepository {

    private final String fileName;

    public FileAccountRepository(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public Set<Long> getAllAccountsByClientId(long clientId) {
        HashSet<Long> numbers = new HashSet<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            long number;
            int clientIdFromFile;

            while ((line = reader.readLine()) != null) {
                if (line.contains("c")) {
                    clientIdFromFile = Integer.parseInt(line.replaceAll("[^0-9]", ""));
                    if (clientId == clientIdFromFile) {
                        number = Integer.parseInt(reader.readLine().replaceAll("[^0-9]", ""));
                        numbers.add(number);
                    }
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return numbers;
    }

}
