package com.sbrf.reboot.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

@Data
@AllArgsConstructor
public class Customer {
    private Long id;
    private String name;
    private String eMail;



}
