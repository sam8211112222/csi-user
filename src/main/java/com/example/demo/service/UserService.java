package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.User;

/**
 * 定義UserService介面
 * @author SamChen
 * @version 1
 * @CreateDate 2021-05-31
 */
public interface UserService {

	public List<User> findAllUser();

	public User findById(int userId);

	public void saveUser(User theUser);

	public void deleteById(int userId);
}
