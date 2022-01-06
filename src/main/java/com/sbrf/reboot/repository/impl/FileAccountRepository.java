package com.sbrf.reboot.repository.impl;

import com.sbrf.reboot.AccountRepository;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
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
    public Set<Long> getAllAccountsByClientId(long clientId) throws FileNotFoundException {
        HashMap<Long, HashSet<Long>> clients = new HashMap<>();
        //String inputFileName = "src/com/company/resources/Accounts.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader((filePath)))) {
            String line;
            //  long clientId;
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

//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//            throw new FileNotFoundException();
//
        } catch (IOException e) {
            e.printStackTrace();
        }
        return clients.get(clientId);


    }
}
