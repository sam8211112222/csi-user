package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UserRepository;
import com.example.demo.entity.User;

/**
 * 實作UserService介面的功能
 * 
 * @author SamChen
 * @version 1
 * @CreateDate 2021-05-31
 */
@Service
public class UserServiceImpl implements UserService {

	private static final Logger logger = LogManager.getLogger(UserServiceImpl.class);

	@Autowired
	private UserRepository userRepository;

//  另一種寫法	
//	@Autowired
//	public UserServiceImpl(UserRepository theUserRepository) {
//		userRepository = theUserRepository;
//	}

	/**
	 * 取得全部user
	 * 
	 * @param 對應Table(name="user")
	 * @return 全部user資料
	 * @author SamChen
	 * @version 1
	 * @CreateDate 2021-05-31
	 */
	@Override
	public List<User> findAllUser() {
		
		logger.info("execute findAllUser()");
		return userRepository.findAll();
	}

	/**
	 * 依userId尋找user資料
	 * 
	 * @param userId
	 * @return user資料
	 * @author SamChen
	 * @version 1
	 * @CreateDate 2021-05-31
	 */
	@Override
	public User findById(int userId) {
		
		logger.info("execute findById()");
		Optional<User> result = userRepository.findById(userId);
		User theUser = null;
		if (result.isPresent()) {
			theUser = result.get();
			logger.info("findById() successfully");
		} else {
			logger.error("Did not find user id" + userId);
			throw new RuntimeException("Did not find user id" + userId);
		}
		return theUser;
	}

	/**
	 * 儲存user資料
	 * 
	 * @param theUser
	 * @return 儲存user資料
	 * @author SamChen
	 * @version 1
	 * @CreateDate 2021-05-31
	 */
	@Override
	public void saveUser(User theUser) {
		
		logger.info("execute findById()");
		userRepository.save(theUser);
	}

	/**
	 * 依userId刪除user資料
	 * 
	 * @param userId
	 * @return 依userId刪除user資料
	 * @author SamChen
	 * @version 1
	 * @CreateDate 2021-05-31
	 */
	@Override
	public void deleteById(int userId) {
		
		logger.info("execute deleteById()");
		userRepository.deleteById(userId);
	}

}
