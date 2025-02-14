package com.codegym.customermanageaspect.service;

import com.codegym.customermanageaspect.model.Customer;

import java.util.List;
import java.util.Optional;

public interface ICustomerService {
    List<Customer> findAll() throws Exception;

    Customer findOne(Long id) throws Exception;
}
