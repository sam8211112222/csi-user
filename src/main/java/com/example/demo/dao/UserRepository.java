package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.User;

/**
 * UserRepository 繼承JpaRepository對資料庫進行數據持久化操作
 * @author SamChen
 * @version 1
 * @CreateDate 2021-05-31
 */
public interface UserRepository extends JpaRepository<User, Integer> {

}
