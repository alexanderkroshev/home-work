package com.sbrf.reboot.repository.impl;

import com.sbrf.reboot.AccountRepository;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileAccountRepository implements AccountRepository {

    private final String fileName;

    public FileAccountRepository(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public Set<Long> getAllAccountsByClientId(long clientId) {
        HashSet<Long> numbers = new HashSet<>();
        String stringFromFile = readFile();
        List<Integer> clientPos = getPositionsByPattern(stringFromFile, "clientId");
        List<Integer> numbersPos = getPositionsByPattern(stringFromFile, "number");
        for ( int i = 0; i < clientPos.size(); i++ ) {
            if (getValue(stringFromFile, clientPos.get(i)) == clientId)
                numbers.add(getValue(stringFromFile, numbersPos.get(i)));
        }
        return numbers;
    }

    public void updateNumberByClientId(long clientId, long oldNumber, long newNumber) {
        String stringFromFile = readFile();
        List<Integer> clientPos = getPositionsByPattern(stringFromFile, "clientId");
        List<Integer> numbersPos = getPositionsByPattern(stringFromFile, "number");
        for ( int i = 0; i < clientPos.size(); i++ ) {
            if (getValue(stringFromFile, clientPos.get(i)) == clientId)
                if (getValue(stringFromFile, numbersPos.get(i)) == oldNumber) {
                    try (PrintWriter out = new PrintWriter(fileName)) {
                        out.write(updateString(stringFromFile, numbersPos.get(i), newNumber));
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    break;
                }
        }
    }

    private String readFile() {
        StringBuilder sb = new StringBuilder();
        try (InputStream input = new FileInputStream(fileName)) {
            for ( int ch; (ch = input.read()) != -1; ) {
                sb.append((char) ch);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    private String updateString(String str, Integer pos, long number) {
        List<Integer> positions = new ArrayList<>();
        for ( int i = pos; i < str.length(); i++ ) {
            if (Character.isDigit(str.charAt(i)))
                positions.add(i);
            if (str.charAt(i) == ',' || str.charAt(i) == '}')
                break;
        }
        return str.substring(0, positions.get(0)) + number + str.substring(positions.get(positions.size() - 1) + 1);
    }

    private List<Integer> getPositionsByPattern(String s, String regex) {
        List<Integer> positions = new ArrayList<>();
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(s);
        while (matcher.find()) {
            positions.add(matcher.start());
        }
        return positions;
    }

    private Long getValue(String str, Integer pos) {
        char[] chars = str.toCharArray();
        StringBuilder valueStr = new StringBuilder();
        for ( int i = pos; i < str.length(); i++ ) {
            if (chars[i] == ',' || chars[i] == '}')
                break;
            if (Character.isDigit(chars[i]))
                valueStr.append(chars[i]);
        }
        return Long.parseLong(valueStr.toString());
    }

}
