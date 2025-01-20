package com.codegym.simple_management;

import com.codegym.simple_management.Service.CustomerService;
import com.codegym.simple_management.enity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/customers")
    public ModelAndView showList(Model model) {
        ModelAndView modelAndView = new ModelAndView("customers/list");
        List<Customer> customers = customerService.getCustomer();
        modelAndView.addObject("customers", customers);
        return modelAndView;
    }
}
