package com.codegym.product_management_thymeleaf.controller;

import com.codegym.product_management_thymeleaf.entity.Product;
import com.codegym.product_management_thymeleaf.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService productService;

    @GetMapping("")
    public String showList(Model model) {
        List<Product> products = productService.getAll();
        model.addAttribute("products", products);
        return "product/list";
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("product", new Product());
        return "product/create";
    }

    @PostMapping("/create")
    public String createStudent(@ModelAttribute("product")Product product,
                                BindingResult bindingResult,
                                RedirectAttributes redirectAttributes,
                                Model model) {
        if(bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "product/create";
        }
        productService.save(product);
        redirectAttributes.addFlashAttribute("message", "Thêm mới thành công");
        return "redirect:/product";
    }

    @GetMapping("/{id}/delete")
    public String deleteStudent(@PathVariable("id")Integer id,
                                RedirectAttributes redirectAttributes) {
        productService.remove(id);
        redirectAttributes.addFlashAttribute("message", "Xóa thành công");
        return "redirect:/product";
    }
}
//PathVariable hoặc RequestParam