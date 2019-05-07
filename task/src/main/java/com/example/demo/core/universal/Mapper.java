 /*
  * Copyright 2019 tuhu.cn All right reserved. This software is the
  * confidential and proprietary information of tuhu.cn ("Confidential
  * Information"). You shall not disclose such Confidential Information and shall
  * use it only in accordance with the terms of the license agreement you entered
  * into with Tuhu.cn
  */
 package com.example.demo.core.universal;

 import tk.mybatis.mapper.common.BaseMapper;
 import tk.mybatis.mapper.common.ConditionMapper;
 import tk.mybatis.mapper.common.IdsMapper;
 import tk.mybatis.mapper.common.special.InsertListMapper;

 /**
  * @Description: 定制版MyBatis Mapper插件接口，如需其他接口参考官方文档自行添加。
  * @author chendesheng chendesheng@tuhu.cn
  * @since 2019/5/7 14:22
  * 注意，之前user_info表主键为int类型，现修改为varcharUserInfo
  * 注意，使用通用mapper需要在实体类的id加上@Id
  */
 public interface Mapper<T> extends BaseMapper<T>, ConditionMapper<T>, IdsMapper<T>, InsertListMapper<T> {
 }
