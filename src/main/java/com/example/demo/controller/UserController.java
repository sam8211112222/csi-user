package com.example.demo.controller;

import java.util.List;

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

@Controller
@RequestMapping("/users")
public class UserController {

	private UserService userService;

	@Autowired
	public UserController(UserService theUserService) {
		userService = theUserService;
	}

	// add mapping for "/list"
	@GetMapping("/list")
	public String listUsers(Model theModel) {
		// get employees from DB
		List<User> theUsers = userService.findAll();
		// add to the spring model
		theModel.addAttribute("users", theUsers);
		return "users/list-users";
	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {

		// create model attribute to bind form data
		User theUser = new User();

		theModel.addAttribute("user", theUser);

		return "users/user-form";
	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("userId") int theId, Model theModel) {
		// get the employee from the service
		User theUser = userService.findById(theId);

		// set employee as a model attribute to pre-populate the form
		theModel.addAttribute("user", theUser);

		// send over to our form
		return "users/user-form";
	}

	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("user") User theUser) {

		// save the employee
		userService.save(theUser);

		// use a redirect to prevent duplicate submissions
		return "redirect:/users/list";
	}

	@GetMapping("/delete")
	public String deleteEmployee(@RequestParam("userId") int theId) {

		// save the employee
		userService.deleteById(theId);

		// use a redirect to prevent duplicate submissions
		return "redirect:/users/list";
	}
}
