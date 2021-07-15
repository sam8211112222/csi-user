package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 定義LoginController類別
 *
 * @author SamChen
 * @version 1
 * @CreateDate 2021-07-13
 */
@Controller
public class LoginController {

    /**
     * 對應/loginPage
     * 導至登入頁面
     *
     * @author SamChen
     * @version 1
     * @CreateDate 2021-07-13
     */
    @GetMapping("/loginPage")
    public String showLoginPage() {
        return "login/loginPage";
    }
}
