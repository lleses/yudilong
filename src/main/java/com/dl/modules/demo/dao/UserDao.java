package com.dl.modules.demo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dl.modules.demo.entity.Eds2TvUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface UserDao extends BaseMapper<Eds2TvUser> {

    List<Eds2TvUser> getUser();


}
