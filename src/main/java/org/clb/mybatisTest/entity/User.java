package org.clb.mybatisTest.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {
    private Long id;

    private String name;

    private String age;

//    private SexEnum sex;

    private String sexName;
}
