package com.cjd.service.impl;


import com.cjd.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cjd.service.UserService;
import com.cjd.dao.UserDao;


import java.util.List;

@Service
@Transactional

public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }


}
