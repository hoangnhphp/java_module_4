package com.codegym.simple_management.Service;

import com.codegym.simple_management.enity.Customer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {
    private static List<Customer> customer = new ArrayList<>();

    static {
        customer.add(new Customer(1, "Nguyen Khac Nhat", "nhat@codegym.com","Ha Noi"));
        customer.add(new Customer(2, "Dang Huy Hoa", "hoa.dang@codegym.com","Da Nang"));
        customer.add(new Customer(3, "Le Thi Chau", "chau.le@codegym.com","sai Gon"));
        customer.add(new Customer(4, "Nguyen Thuy Duong", "duong.nguyen@codegym.com","Ha Noi"));
        customer.add(new Customer(5, "CodeGym", "nhat@codegym.com","Viet Nam"));
    }

    public static List<Customer> getCustomer() {
        return customer;
    }
}
