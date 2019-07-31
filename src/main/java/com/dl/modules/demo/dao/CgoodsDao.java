package com.dl.modules.demo.dao;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dl.modules.demo.entity.CgoodsTemplate;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
@DS("slave")
public interface CgoodsDao extends BaseMapper<CgoodsTemplate> {


    List<CgoodsTemplate> getAll();

}
