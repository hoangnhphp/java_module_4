package com.codegym.sandwich_spring;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;
import java.util.Objects;

@Controller
@RequestMapping("/sandwich")
public class SandwichController {

    @GetMapping("")
    public String sandwich() {
        return "index";
    }

    @PostMapping("/save")
    public String save(@RequestParam (name = "spices") String[] data, ModelMap model) {
//        String[] spices = data.split(",");
        model.addAttribute("spices", data);
        return "result";
    }
}
