package com.sbrf.reboot.repository;

import com.sbrf.reboot.dto.Customer;
import lombok.NonNull;

import java.util.List;

public interface CustomerRepository {

    boolean createCustomer(@NonNull String userName, String eMail);

    List<Customer> getAll();

    List<Customer> findByName(String name);

    void truncate();
}
