package com.dl.demo.dao;

import com.baomidou.dynamic.datasource.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dl.demo.entity.CgoodsTemplate;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CgoodsDao extends BaseMapper<CgoodsTemplate> {

    @DS("two")
    List<CgoodsTemplate> getAll();

}
