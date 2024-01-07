package com.svarto.sitespringredis.controller;

import com.svarto.sitespringredis.Product;
import com.svarto.sitespringredis.User;
import com.svarto.sitespringredis.services.ProductService;
import com.svarto.sitespringredis.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final ProductService productService;
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/registration")
    public String registration(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "registration";
    }


    @PostMapping("/registration")
    public String createUser(@ModelAttribute("user") User user, Model model) {
        if(!userService.createUser(user)){
            model.addAttribute("errorMessage", "Пользователь с таким email уже существует анлак");
            return "redirect:/login";
        }
        return "redirect:/";
    }

    @GetMapping("/hello")
    public String securityUrl() {
        return "hello";
    }

    @GetMapping("/user/{user}")
    public String userinfo(@PathVariable("user")User user, Model model) {
        model.addAttribute("user", productService.getUserById(user.getId()));
        model.addAttribute("products", userService.getProductByUser_id(user));

        return "user_info";
    }


}
