package com.example.abcd;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Controller
@RequiredArgsConstructor
public class ProductController {

    private final ProductService service;

    @GetMapping
    public String home(Model model){
        model.addAttribute("listProduct", service.findAll());
        return "index";
    }

    @GetMapping("/new")
    public String addProduct(@ModelAttribute Product product, Model model){
        model.addAttribute("product", product);
        return "new_product";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Product product){
        service.save(product);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable(name="id") int id, @ModelAttribute Product product){
        service.findById(id);
        return "edit_product";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable(name = "id") int id, @ModelAttribute Product product){
        service.delete(id);
        return "redirect:/";
    }
}
