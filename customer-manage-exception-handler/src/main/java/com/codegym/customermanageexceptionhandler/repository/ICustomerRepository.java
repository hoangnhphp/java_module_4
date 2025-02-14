package com.codegym.customermanageexceptionhandler.repository;

import com.codegym.customermanageexceptionhandler.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Long> {
}
