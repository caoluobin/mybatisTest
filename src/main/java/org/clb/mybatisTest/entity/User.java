package org.clb.mybatisTest.entity;

import lombok.Data;
import org.clb.mybatisTest.enums.SexEnum;

@Data
public class User {
    private Long id;

    private String name;

    private String age;

    private SexEnum sex;

    private String sexName;
}
