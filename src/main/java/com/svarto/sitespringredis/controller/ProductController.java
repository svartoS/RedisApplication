package com.svarto.sitespringredis.controller;

import com.svarto.sitespringredis.Product;
import com.svarto.sitespringredis.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping("/")
    public String products(@RequestParam(name = "title", required = false) String title, Principal principal, Model model) {
        model.addAttribute("products", productService.list(title));
        model.addAttribute("user", productService.getUserByPrincipal(principal));
        return "index";
    }

    @GetMapping("/product/{id}")
    public String productInfo(@PathVariable Long id, Model model) {
        model.addAttribute("product", productService.getProductById(id));
        return "index_info";
    }

    @PostMapping("/product/create")
    public String createProduct(@ModelAttribute("product")Product product, Principal principal) {
        productService.saveProduct(principal, product);
        return "redirect:/";
    }

    @PostMapping("/product/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return "redirect:/";
    }
}
