package com.example.demo.dao;

import com.example.demo.entity.Fish;

public interface FishMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Fish record);

    int insertSelective(Fish record);

    Fish selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Fish record);

    int updateByPrimaryKey(Fish record);
}