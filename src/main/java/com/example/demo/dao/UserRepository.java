package com.example.demo.dao;

import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * UserRepository 繼承JpaRepository對資料庫進行數據持久化操作
 *
 * @author SamChen
 * @version 2
 * @CreateDate 2021-07-13
 */
public interface UserRepository extends JpaRepository<User, Integer> {

    /**
     * 列出enabled=true的使用者
     *
     * @author SamChen
     * @version 1
     * @CreateDate 2021-07-13
     */
    @Query("select u from User u where u.enabled = true ")
    public List<User> findAllByEnabled();

    /**
     * 列出enabled=false的使用者
     *
     * @author SamChen
     * @version 1
     * @CreateDate 2021-07-13
     */
    @Query("select u from User u where u.enabled = false ")
    public List<User> findAllByUnabled();


    /**
     * 把enabled狀態改成true已啟用使用者
     * 必須加@Transactional和@Modifying，來代表這是一個事務級別的操作
     *
     * @author SamChen
     * @version 1
     * @CreateDate 2021-07-13
     */
    @Transactional
    @Modifying
    @Query("update User u SET u.enabled = true where u.id = :id")
    public void setEnabledtoTrue(@Param("id") Integer userId);
}
