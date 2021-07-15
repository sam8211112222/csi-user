package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * 定義UserController類別
 * 對應/users
 *
 * @author SamChen
 * @version 2
 * @CreateDate 2021-07-13
 */
@Controller
@RequestMapping("/users")
public class UserController {

    private static final Logger logger = LogManager.getLogger(UserController.class);

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * 對應/list
     * 列出所有啟用的user
     *
     * @author SamChen
     * @version 2
     * @CreateDate 2021-07-13
     */
    @GetMapping("/list")
    public String listEnabledUsers(Model theModel) {

        logger.info("Get users from DB");
        List<User> theUsers = userService.findAllByEnabled();

        logger.info("Add to the spring model");
        theModel.addAttribute("users", theUsers);
        theModel.addAttribute("status", true);

        logger.info("show list-users page");
        return "users/list-users";
    }

    /**
     * 對應/non-list
     * 列出所有未啟用的user
     *
     * @author SamChen
     * @version 2
     * @CreateDate 2021-07-13
     */
    @GetMapping("/non-list")
    public String listUnabledUsers(Model theModel) {

        logger.info("Get users from DB");
        List<User> theUsers = userService.findAllByUnabled();
        logger.info("Add to the spring model");
        theModel.addAttribute("status", false);
        theModel.addAttribute("users", theUsers);

        logger.info("show list-users page");
        return "users/list-users";
    }

    /**
     * 對應/showFormForAdd
     * 新增user
     *
     * @author SamChen
     * @version 1
     * @CreateDate 2021-05-31
     */
    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {

        logger.info("create model attribute to bind form data");
        User user = new User();

        logger.info("Add user attribute");
        theModel.addAttribute("user", user);

        logger.info("to user-form page");
        return "users/user-add-form";
    }

    /**
     * 對應/showFormForUpdate
     * 修改user
     *
     * @author SamChen
     * @version 1
     * @CreateDate 2021-05-31
     */
    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("userId") Integer userId, Model theModel) {
        logger.info("get the user from the service");
        User user = userService.findById(userId);
        logger.info("set user as a model attribute to pre-populate the form");
        theModel.addAttribute("user", user);

        logger.info("to user-add-form page");
        return "users/user-update-form";
    }

    /**
     * 對應/save
     * 儲存user
     *
     * @author SamChen
     * @version 1
     * @CreateDate 2021-05-31
     */
    @PostMapping("/save")
    public String saveUser(@Valid @ModelAttribute("user") User user, BindingResult result) {
        logger.info(user.getId());
        logger.info("Save the user");
        if (result.hasErrors()) {
            logger.info("Occurs error while saving");
            return "users/user-add-form";
        } else {
            userService.saveUser(user);
            logger.info("Save success! Redirect:/users/list");
            return "redirect:/users/list";
        }
    }

    /**
     * 更新/update
     * 更新user
     *
     * @author SamChen
     * @version 2
     * @CreateDate 2021-07-13
     */
    @PostMapping("/update")
    public String updateUser(@Valid @ModelAttribute("user") User user, BindingResult result) {
        logger.info(user.getId());
        logger.info("update the user");
        if (result.hasErrors()) {
            logger.info("Occurs error while updating");
            return "users/user-update-form";
        } else {
            userService.saveUser(user);
            logger.info("Update success! Redirect:/users/list");
            return "redirect:/users/list";
        }
    }

    /**
     * 更新/update
     * 更新user
     *
     * @author SamChen
     * @version 1
     * @CreateDate 2021-05-31
     */
    @GetMapping("/enable")
    public String enabledUser(@RequestParam("userId") Integer userId) {
        logger.info("Enabled the user");
        userService.setEnabledtoTrue(userId);
        logger.info("Enabled success! Redirect:/users/list");
        return "redirect:/users/list";
    }

    /**
     * 對應/delete
     * 刪除user
     *
     * @author SamChen
     * @version 1
     * @CreateDate 2021-05-31
     */
    @GetMapping("/delete")
    public String deleteUser(@RequestParam("userId") Integer userId) {

        logger.info("Delete the user");
        userService.deleteById(userId);

        logger.info("redirect:/users/list");
        return "redirect:/users/list";
    }
}