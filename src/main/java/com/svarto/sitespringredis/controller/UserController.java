package com.svarto.sitespringredis.controller;

import com.svarto.sitespringredis.User;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.lang.NonNull;
import org.springframework.lang.NonNullFields;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class UserController {
    User newUser;
    @Autowired
    private RedisTemplate<String, User> redisTemplate;

    @GetMapping("/register")
    public String showForm(Model model){
        User user = new User();
        model.addAttribute("user", user);

        return "register_form";
    }

    @PostMapping(value = "/register_success")
    public String  submitForm(@RequestBody @ModelAttribute("user") User user){
        if (user.getEmail() == null) {
            throw new IllegalArgumentException("Email cannot be null");
        }
        System.out.println("Going to set value of person in redis");
        redisTemplate.opsForValue().set(user.getEmail(), user);
        newUser = copyUser(user);


        return "register_success";
    }
    @GetMapping(value = "/register_success")
    public String getDataFromRedis(@ModelAttribute("user") User user) {
        System.out.println(newUser.toString());
        return "index";
    }
    public User copyUser(User originalUser) {
        User newUser = new User();
        newUser.setEmail(originalUser.getEmail());
        newUser.setBirthday(originalUser.getBirthday());
        newUser.setName(originalUser.getName());
        newUser.setPassword(originalUser.getPassword());
        return newUser;
    }

}
