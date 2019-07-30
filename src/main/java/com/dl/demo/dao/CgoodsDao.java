package com.dl.demo.dao;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dl.demo.entity.CgoodsTemplate;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

//@DS 可以注解在方法上和类上，同时存在方法注解优先于类上注解。
@Mapper
@DS("slave")
public interface CgoodsDao extends BaseMapper<CgoodsTemplate> {


    List<CgoodsTemplate> getAll();

}
