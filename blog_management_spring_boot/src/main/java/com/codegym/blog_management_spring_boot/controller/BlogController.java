package com.codegym.blog_management_spring_boot.controller;

import com.codegym.blog_management_spring_boot.model.Blog;
import com.codegym.blog_management_spring_boot.service.IBlogService;
import com.codegym.blog_management_spring_boot.service.impl.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("blogs")
public class BlogController {
    @Autowired
    private IBlogService blogService;

    @GetMapping("")
    public String index(Model model) {
        List<Blog> blogs = blogService.getAll();
        model.addAttribute("blogs", blogs);
        return "blogs/index";
    }

    @GetMapping("/{id}")
    public String detail(Model model, @PathVariable long id, RedirectAttributes redirectAttributes) {
        Blog b = blogService.findById(id);
        if (b == null) {
            redirectAttributes.addFlashAttribute("errors", "Blog không tồn tại");
            return "redirect:/blogs";
        }
        model.addAttribute("blog", b);
        return "blogs/detail";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("blog", new Blog());
        return "blogs/create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("blog")Blog blog,
                         BindingResult bindingResult,
                         RedirectAttributes redirectAttributes,
                         Model model
    ) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "/blogs/create";
        }
        blogService.save(blog);
        redirectAttributes.addFlashAttribute("message", "Thêm mới thành công");
        return "redirect:/blogs";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable("id")Long id,
                                RedirectAttributes redirectAttributes) {
        blogService.remove(id);
        redirectAttributes.addFlashAttribute("message", "Xóa thành công");
        return "redirect:/blogs";
    }
}
