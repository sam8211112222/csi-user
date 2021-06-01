package com.example.demo.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;

/**
 * 定義UserController類別
 * 對應/users
 * @author SamChen
 * @version 1
 * @CreateDate 2021-05-31
 */
@Controller
@RequestMapping("/users")
public class UserController {

	private static final Logger logger = LogManager.getLogger(UserController.class);

	@Autowired
	private UserService userService;

//  另一種寫法
//	@Autowired
//	public UserController(UserService theUserService) {
//		userService = theUserService;
//	}
	
	/**對應/list
	 * 列出所有user
	 * @author SamChen
	 * @version 1
	 * @CreateDate 2021-05-31
	 */
	@GetMapping("/list")
	public String listUsers(Model theModel) {
		
		logger.info("Get users from DB");
		List<User> theUsers = userService.findAllUser();
		
		logger.info("Add to the spring model");
		theModel.addAttribute("users", theUsers);
		
		logger.info("show list-users page");
		return "users/list-users";
	}
	
	/**對應/showFormForAdd
	 * 新增user
	 * @author SamChen
	 * @version 1
	 * @CreateDate 2021-05-31
	 */
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		logger.info("create model attribute to bind form data");
		User theUser = new User();
		
		logger.info("Add user attribute");
		theModel.addAttribute("user", theUser);
		
		logger.info("to user-form page");
		return "users/user-form";
	}
	
	/**對應/showFormForUpdate
	 * 修改user
	 * @author SamChen
	 * @version 1
	 * @CreateDate 2021-05-31
	 */
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("userId") int userId, Model theModel) {
		
		logger.info("get the user from the service");
		User theUser = userService.findById(userId);
		
		logger.info("set user as a model attribute to pre-populate the form");
		theModel.addAttribute("user", theUser);

		logger.info("to user-form page");
		return "users/user-form";
	}
	
	/**對應/save
	 * 儲存user
	 * @author SamChen
	 * @version 1
	 * @CreateDate 2021-05-31
	 */
	@PostMapping("/save")
	public String saveUser(@ModelAttribute("user") User theUser) {

		logger.info("Save the user");
		userService.saveUser(theUser);
		
		logger.info("redirect:/users/list");
		return "redirect:/users/list";
	}
	
	/**對應/delete
	 * 刪除user
	 * @author SamChen
	 * @version 1
	 * @CreateDate 2021-05-31
	 */
	@GetMapping("/delete")
	public String deleteUser(@RequestParam("userId") int userId) {

		logger.info("Delete the user");
		userService.deleteById(userId);
		
		logger.info("redirect:/users/list");
		return "redirect:/users/list";
	}
}
