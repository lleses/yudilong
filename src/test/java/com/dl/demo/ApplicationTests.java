package com.dl.demo;

import com.dl.demo.dao.CgoodsDao;
import com.dl.demo.dao.UserDao;
import com.dl.demo.entity.CgoodsTemplate;
import com.dl.demo.entity.Eds2TvUser;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

    @Autowired
    private UserDao userDao;
    @Autowired
    private CgoodsDao cgoodsDao;

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

    @Test
    public void getCgoods() {
        CgoodsTemplate cgoodsTemplate = cgoodsDao.selectById("1149166740237045761");
        System.out.println(cgoodsTemplate);
    }

    @Test
    public void getCgoodsList() {
        PageHelper.startPage(1, 2);
        List<CgoodsTemplate> list = cgoodsDao.getAll();
        PageInfo<CgoodsTemplate> page = new PageInfo<>(list);
        System.out.println(page);
    }

}
