package com.example.demo.service;

import com.example.demo.entity.User;

import java.util.List;

/**
 * 定義UserService介面
 *
 * @author SamChen
 * @version 2
 * @CreateDate 2021-07-13
 */
public interface UserService {

	public List<User> findAllUser();

	public List<User> findAllByEnabled();

	public List<User> findAllByUnabled();

	public User findById(Integer userId);

	public void saveUser(User theUser);

	public void deleteById(Integer userId);

	public void setEnabledtoTrue(Integer userId);
}

