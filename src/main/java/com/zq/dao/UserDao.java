package com.zq.dao;

import com.zq.entity.User;

public interface UserDao {
    public User selectByUsername(String username);
}
