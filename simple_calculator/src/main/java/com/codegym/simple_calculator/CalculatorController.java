package com.codegym.simple_calculator;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/calculator")
public class CalculatorController {

    @GetMapping("")
    public String calculator() {
        return "index";
    }

    @PostMapping("/result")
    public String calculatorResult(
            @RequestParam("num1") double number1,
            @RequestParam("num2") double number2,
            @RequestParam("operation") String operation,
            ModelMap model
    ) {

        double result = 0;

        switch (operation) {
            case "add":
                result = number1 + number2;
                break;
            case "subtract":
                result = number1 - number2;
                break;
            case "multiply":
                result = number1 * number2;
                break;
            case "divide":
                if (number2 != 0) {
                    result = number1 / number2;
                } else {
                    model.addAttribute("error", "Cannot divide by zero!");
                }
                break;
            default:
                model.addAttribute("error", "Invalid operation!");
        }

        model.addAttribute("result", result);
        model.addAttribute("operation", operation);
        return "index";
    }
}
