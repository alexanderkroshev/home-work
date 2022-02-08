package com.sbrf.reboot.repository;

import com.sbrf.reboot.dto.Customer;
import lombok.NonNull;

import java.util.List;

public interface CustomerRepository {

    //void createCustomer(@NonNull String userName, String eMail);
    void createCustomer();

    List<Customer> getAll();

}
