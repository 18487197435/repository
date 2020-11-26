package com.cn.fanguangfu.vo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author Bangsun
 * @date 2020-11-26
 */
@Table(name = "Student")
public class Student implements Serializable {


    private static final long serialVersionUID = 4952021692238958258L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "JDBC")
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "sex")
    private String sex;

    @Column(name = "age")
    private Integer age;

    @Column(name = "create_time")
    @Transient
    private Date createTime;

    @Column(name = "update_time")
    @Transient
    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
