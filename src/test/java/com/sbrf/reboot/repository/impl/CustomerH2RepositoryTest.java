package com.sbrf.reboot.repository.impl;

import com.sbrf.reboot.dto.Customer;
import com.sbrf.reboot.repository.CustomerRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CustomerH2RepositoryTest {

    private static CustomerRepository customerRepository;

    @BeforeAll
    public static void before() {
        customerRepository = new CustomerH2Repository();
        customerRepository.truncate();
    }

    @Test
    void getAll() {

        boolean tomCreated = customerRepository.createCustomer("Tom", "tom@ya.ru");

        List<Customer> all = customerRepository.getAll();

        assertTrue(all.size() != 0);
    }

    @Test
    void createCustomer() {

        boolean mariaCreated = customerRepository.createCustomer("Maria", "maria98@ya.ru");

        assertTrue(mariaCreated);
    }

    @Test
    void findCustomerByName() {

        boolean bobCreated = customerRepository.createCustomer("Bob", "bob@ya.ru");

        List<Customer> customers = customerRepository.findByName("bob");

        assertTrue(customers.get(0).getName().toLowerCase(Locale.ROOT).contains("bob"));
    }

}