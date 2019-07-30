package com.dl.demo.service;

import com.dl.demo.dao.UserDao;
import com.dl.demo.entity.Eds2TvUser;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;




}
