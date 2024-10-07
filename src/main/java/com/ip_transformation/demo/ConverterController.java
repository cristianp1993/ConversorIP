package com.ip_transformation.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ConverterController {
    @Autowired
    private ConversionService conversionService;

    @GetMapping("/")
    public String index() {
        return "index";  // Retorna la vista index.html
    }

    @PostMapping("/result")
    public String convert(
            @RequestParam("inputValue") String inputValue,
            @RequestParam("conversionType") String conversionType,
            Model model) {

        String result = conversionService.performConversion(inputValue, conversionType);
        model.addAttribute("result", result);
        return "result";  // Retorna la vista result.html con el resultado
    }
}
