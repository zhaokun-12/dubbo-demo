package com.example.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * (Person)实体类
 *
 * @author makejava
 * @since 2020-10-23 10:32:36
 */
@Data
@Accessors(chain = true)
public class Person implements Serializable {
    private static final long serialVersionUID = 776344421077170179L;

    private Integer id;

    private String nameRmai;

    private Integer age;
}