package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.User;

public interface UserService {

	public List<User> findAll();

	public User findById(int theId);

	public void save(User theUser);

	public void deleteById(int theId);
}
