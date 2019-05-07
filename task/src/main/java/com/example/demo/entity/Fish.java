package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Fish implements Serializable {
    
    private static final long serialVersionUID = -8083613965989297548L;
    private Integer id;

    private String name;

    private String publishname;

    private Float price;

    
}