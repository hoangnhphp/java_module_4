package com.codegym.currency_change;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("/currency")
public class CurrencyController {
    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/")
    public String post(@RequestBody String rawData) {
        String data = rawData;
        return "converter";
    }
}
