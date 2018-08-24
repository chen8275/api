package com.example.demo.dao;

import com.example.demo.entity.Fish;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface FishMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Fish record);

    int insertSelective(Fish record);

    Fish selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Fish record);

    int updateByPrimaryKey(Fish record);
    
    List<Fish> listFish(@Param("pageNum") int pageNum,@Param("pageSize") int pageSize);
    
    int countFish();
}