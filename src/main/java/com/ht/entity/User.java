package com.ht.entity;

import java.io.Serializable;

/**
 * @auth Qiu
 * @time 2018/3/6
 **/

public class User implements Serializable{
    private Long id;
    private String uname;
    private Integer age;
    private String sex;

    public User(Long id, String uname, Integer age, String sex) {
        this.id = id;
        this.uname = uname;
        this.age = age;
        this.sex = sex;
    }

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
