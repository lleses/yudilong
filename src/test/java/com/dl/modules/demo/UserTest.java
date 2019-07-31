package com.dl.modules.demo;

import com.dl.ApplicationTest;
import com.dl.modules.demo.dao.UserDao;
import com.dl.modules.demo.entity.Eds2TvUser;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.List;

public class UserTest extends ApplicationTest {

    @Autowired
    private UserDao userDao;

    @Test
    public void add() {
        Eds2TvUser user = new Eds2TvUser();
//        user.setUserId(1112l);
        user.setMobile("1213");
        user.setStoreId("11111");
        user.setAccessToken("xxx");
        user.setMachineCode("ttt");
        user.setCreateTime(LocalDateTime.now());
        user.setUpdateTime(LocalDateTime.now());
        userDao.insert(user);
        System.out.println(user);
    }

    @Test
    public void get() {
        Eds2TvUser user = userDao.selectById("1149166740237045761");
        System.out.println(user);
    }


    @Test
    public void getList() {
        PageHelper.startPage(1, 2);
        List<Eds2TvUser> list = userDao.getUser();
        PageInfo<Eds2TvUser> page = new PageInfo<>(list);
        System.out.println(page);
    }


}
