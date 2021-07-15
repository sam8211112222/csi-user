package com.example.demo.service;

import com.example.demo.dao.UserRepository;
import com.example.demo.entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


/**
 * 實作UserService介面的功能
 *
 * @author SamChen
 * @version 2
 * @CreateDate 2021-07-13
 */
@Service
public class UserServiceImpl implements UserService {

    private static final Logger logger = LogManager.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

    /**
     * 取得全部user
     *
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
     * 取得全部已啟用的user
     *
     * @return 全部已啟用的user資料
     * @author SamChen
     * @version 1
     * @CreateDate 2021-07-13
     */
    @Override
    public List<User> findAllByEnabled() {
        logger.info("execute findAllByEnabled()");
        return userRepository.findAllByEnabled();
    }

    /**
     * 取得全部未啟用的user
     *
     * @return 全部未啟用的user資料
     * @author SamChen
     * @version 1
     * @CreateDate 2021-07-13
     */
    @Override
    public List<User> findAllByUnabled() {
        logger.info("execute findAllByUnabled()");
        return userRepository.findAllByUnabled();
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
    public User findById(Integer userId) {

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
     * @param user
     * @return 儲存user資料
     * @author SamChen
     * @version 1
     * @CreateDate 2021-05-31
     */
    @Override
    public void saveUser(User user) {
        logger.info("execute findById()");
        BCryptPasswordEncoder bcryptPasswordEncoder = new BCryptPasswordEncoder();
        if (!user.getPassword().equals("")) {
            user.setPassword(bcryptPasswordEncoder.encode(user.getPassword()));
            logger.info(user);
            userRepository.save(user);
        } else {
            logger.info(user);
            userRepository.save(user);
        }
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
    public void deleteById(Integer userId) {

        logger.info("execute deleteById()");
        userRepository.deleteById(userId);
    }

    /**
     * 依userId啟用User
     *
     * @param userId
     * @return 依userId啟用User
     * @author SamChen
     * @version 1
     * @CreateDate 2021-07-13
     */
    @Override
    public void setEnabledtoTrue(Integer userId) {
        logger.info("execute EnabledtoTrue()");
        userRepository.setEnabledtoTrue(userId);
    }

}
