package com.cn.fanguangfu.dao;

import com.cn.fanguangfu.vo.Student;
import tk.mybatis.mapper.additional.insert.InsertListMapper;
import tk.mybatis.mapper.common.Mapper;

/**
 * @author Bangsun
 * @date 2020-11-26
 */
public interface StudentMapper extends Mapper<Student>, InsertListMapper<Student> {
}
