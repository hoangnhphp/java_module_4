package com.codegym.product_management_thymeleaf.service.impl;

import com.codegym.product_management_thymeleaf.entity.Product;
import com.codegym.product_management_thymeleaf.repository.ProductRepository;
import com.codegym.product_management_thymeleaf.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {

//    DI sử dụng Field injection
//    DI bằng setter và constructor
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAll() {
        List<Product> students = productRepository.getAll();

        return students;
    }

    @Override
    public void save(Product s) {
        productRepository.save(s);
    }

    @Override
    public void update(int id, Product s) {

    }

    @Override
    public void remove(Integer id) {
        productRepository.remove(id);
    }

    @Override
    public Product findById(int id) {
        return null;
    }

    @Override
    public List<Product> findByName(String name) {
        return null;
    }

}
