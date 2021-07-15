package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 定義LoginController類別
 * 對應/loginPage
 * @author SamChen
 * @version 1
 * @CreateDate 2021-07-13
 */
@Controller
public class LoginController {

    @GetMapping("/loginPage")
    public String showLoginPage(){
        return "login/loginPage";
    }
}
