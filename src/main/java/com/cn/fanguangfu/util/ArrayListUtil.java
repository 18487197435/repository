package com.cn.fanguangfu.util;

import com.cn.fanguangfu.vo.Student;

import java.util.List;

/**
 * @author Bangsun
 * @date 2020-11-26
 */
public class ArrayListUtil {

    public static boolean isInclude(List<Student> list, String name){
        return list.stream().anyMatch(e->e.getName().equals(name));
    }


}
