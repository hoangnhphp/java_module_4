package com.codegym.customer.service.impl;

import com.codegym.customer.model.Customer;
import com.codegym.customer.repository.CustomerRepository;
import com.codegym.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@Service
public class CustomerServiceImplWithSpringData implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> findAll() {
        return streamAll().collect(Collectors.toList());
    }

    @Override
    public Page<Customer> findAll(Pageable pageInfo){
        return customerRepository.findAll(pageInfo);
    }

    @Override
    public List<Customer> search(String keyword) {
        Iterable<Customer> searchResult = customerRepository
                .findAllByNameContainsOrEmailContainsOrAddressContains(keyword, keyword, keyword);
        return streamAll(searchResult).collect(Collectors.toList());
    }

    @Override
    public Page<Customer> search(String keyword, Pageable pageInfo) {
        return customerRepository
                .findAllByNameContainsOrEmailContainsOrAddressContains(keyword, keyword, keyword, pageInfo);
    }

    @Override
    public Optional<Customer> findOne(Long id) throws Exception {
        Optional<Customer> customerOptional = customerRepository.findById(id);
        if (!customerOptional.isPresent()) {
            throw new Exception("customer not found!");
        }
        return customerOptional;
    }

    @Override
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public List<Customer> save(List<Customer> customers) {
        Iterable<Customer> updatedCustomers = customerRepository.saveAll(customers);
        return streamAll(updatedCustomers).collect(Collectors.toList());
    }

    @Override
    public boolean exists(Long id) {
        return customerRepository.existsById(id);
    }

    @Override
    public List<Customer> findAll(List<Long> ids) {
        Iterable<Customer> customers = customerRepository.findAllById(ids);
        return streamAll(customers).collect(Collectors.toList());
    }

    @Override
    public long count() {
        return customerRepository.count();
    }

    @Override
    public void delete(Long id) {
        customerRepository.deleteById(id);
    }

    @Override
    public void delete(Customer customer) {
        customerRepository.delete(customer);
    }

    @Override
    public void delete(List<Customer> customers) {
        customerRepository.deleteAll(customers);
    }

    @Override
    public void deleteAll() {
        customerRepository.deleteAll();
    }

    private Stream<Customer> streamAll() {
        return StreamSupport.stream(customerRepository.findAll().spliterator(), false);
    }

    private Stream<Customer> streamAll(Iterable<Customer> customers) {
        return StreamSupport.stream(customers.spliterator(), false);
    }
}
