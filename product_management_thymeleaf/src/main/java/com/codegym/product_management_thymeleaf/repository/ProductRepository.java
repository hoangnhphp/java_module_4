package com.codegym.product_management_thymeleaf.repository;

import com.codegym.product_management_thymeleaf.dto.StudentDTO;
import com.codegym.product_management_thymeleaf.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {
    private static List<Product> products = new ArrayList<>();

    static {
        products.add(new Product(1, "Máy giặt", "QN", 10000000, "hitachi"));
        products.add(new Product(2, "Tủ lạnh", "QN", 10000000, "toshiba"));
        products.add(new Product(3, "Tivi", "QN", 10000000, "LG"));
        products.add(new Product(4, "Laptop", "QN", 10000000, "Asus"));
        products.add(new Product(5, "Máy sấy tóc", "QN", 10000000, "toshiba"));
        products.add(new Product(6, "Tủ lạnh", "QN", 10000000, "LG"));
        products.add(new Product(7, "Lò vi sóng", "QN", 10000000, "LG"));
        products.add(new Product(8, "Quạt", "QN", 10000000, "LG"));
        products.add(new Product(9, "Chuột máy tính", "QN", 10000000, "Logitech"));
        products.add(new Product(10, "Tai nghe", "QN", 10000000, "Logitech"));
        products.add(new Product(11, "Điện thoại", "QN", 10000000, "Samsung"));
    }

    public List<Product> getAll() {
        return products;
    }

    public void save(Product s) {
        s.setId(products.get(products.size() - 1).getId() + 1);
        products.add(s);
    }

    public void remove(Integer id) {
        for (Product s : products) {
            if (s.getId() == id) {
                products.remove(s);
                break;
            }
        }
    }

    public Product findById(int id) {
        return products.get(id);
    }


    public void update(int id, Product product) {
        int index = products.indexOf(product);
        products.set(index, product);
    }
}
