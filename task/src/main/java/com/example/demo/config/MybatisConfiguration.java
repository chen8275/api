 /*
  * Copyright 2019 tuhu.cn All right reserved. This software is the
  * confidential and proprietary information of tuhu.cn ("Confidential
  * Information"). You shall not disclose such Confidential Information and shall
  * use it only in accordance with the terms of the license agreement you entered
  * into with Tuhu.cn
  */
 package com.example.demo.config;

 import org.apache.ibatis.session.SqlSessionFactory;
 import org.mybatis.spring.SqlSessionFactoryBean;
 import org.springframework.context.annotation.Bean;
 import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
 import org.springframework.core.io.support.ResourcePatternResolver;
 import tk.mybatis.spring.mapper.MapperScannerConfigurer;

 import javax.sql.DataSource;

 /**
  * @author chendesheng chendesheng@tuhu.cn
  * @since 2019/5/7 14:20
  */
 public class MybatisConfiguration {
    
     @Bean
     public SqlSessionFactory sqlSessionFactoryBean(DataSource dataSource) throws Exception {
         SqlSessionFactoryBean factory = new SqlSessionFactoryBean();
         factory.setDataSource(dataSource);
         factory.setTypeAliasesPackage("com.example.demo.entity");
         // 添加XML目录
         ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
         factory.setMapperLocations(resolver.getResources("classpath:mapper/*.xml"));
         return factory.getObject();
     }
    
     @Bean
     public MapperScannerConfigurer mapperScannerConfigurer() {
         MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
         mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactoryBean");
         mapperScannerConfigurer.setBasePackage("com.example.demo.dao");
         return mapperScannerConfigurer;
     }
 }
