package com.example.demo.dao;

import com.example.demo.entity.Shop;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface ShopMapper {
    int insert(Shop record);
    int insertSelective(Shop record);
    
    List<Shop> listShop(@Param("pageNum") int pageNum,@Param("pageSize") int pageSize);
    int updateById(@Param("name") String name,@Param("id") int id);
    int deleteById(@Param("id") int id);
}