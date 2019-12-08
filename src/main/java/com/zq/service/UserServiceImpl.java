package com.zq.service;

import com.zq.dao.UserDao;
import com.zq.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author zhaoqi
 * @version 1.8
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public User selectByUsername(User user) {
        User user1 = userDao.selectByUsername(user.getUsername());
        return user1;
    }
}
