package com.example.demo.dao;

import com.example.demo.entity.Fish;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface FishMapper {
    
    int deleteByPrimaryKey(Integer id);

    int insert(Fish record);

    int insertSelective(Fish record);

    Fish selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Fish record);

    int updateByPrimaryKey(Fish record);
    
    List<Fish> selectFish(@Param("name") String name,@Param("publishName") String publishName,@Param("pageIndex") int pageIndex,@Param("pageSize") int pageSize); 
        
    List<Fish> listFish(@Param("pageNum") int pageNum,@Param("pageSize") int pageSize);
    
    Page<Fish> list();
    
    int countFish();
    
    int updateStatement(@Param("name") String name,@Param("id") Integer id);
}