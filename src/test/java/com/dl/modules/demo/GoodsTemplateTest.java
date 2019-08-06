package com.dl.modules.demo;

import com.dl.ApplicationTest;
import com.dl.modules.demo.dao.CgoodsDao;
import com.dl.modules.demo.entity.CgoodsTemplate;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class GoodsTemplateTest extends ApplicationTest {

    @Autowired
    private CgoodsDao cgoodsDao;


    @Test
    public void getCgoods() {
        CgoodsTemplate cgoodsTemplate = cgoodsDao.selectById("300");
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
