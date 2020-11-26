package com.cn.fanguangfu.service;

import com.cn.fanguangfu.dao.StudentMapper;
import com.cn.fanguangfu.util.ArrayListUtil;
import com.cn.fanguangfu.util.DistinctTask;
import com.cn.fanguangfu.vo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ForkJoinPool;

/**
 * @author Bangsun
 * @date 2020-11-26
 */
@Service
public class StudentService {

    @Autowired
    private StudentMapper studentMapper;

    public String addStudent(){
        List<Student> list = new ArrayList<>();
        for (int i=0;i<10000;i++){
            Student student = new Student();
            student.setName("赵情"+i);
            student.setSex("女");
            student.setAge(27);
            list.add(student);
        }
        int res = studentMapper.insertList(list);
        if (res>0){
            list.clear();
        }
        for (int i=0;i<10000;i++){
            Student student = new Student();
            student.setName("杨雪菲"+i);
            student.setSex("女");
            student.setAge(27);
            list.add(student);
        }
        res = studentMapper.insertList(list);
        if (res>0){
            list.clear();
        }
        for (int i=0;i<10000;i++){
            Student student = new Student();
            student.setName("黄佳佳"+i);
            student.setSex("女");
            student.setAge(27);
            list.add(student);
        }
        res = studentMapper.insertList(list);
        if (res>0){
            list.clear();
        }
        for (int i=0;i<10000;i++){
            Student student = new Student();
            student.setName("刘月"+i);
            student.setSex("女");
            student.setAge(27);
            list.add(student);
        }
        res = studentMapper.insertList(list);
        if (res>0){
            list.clear();
        }
        for (int i=0;i<10000;i++){
            Student student = new Student();
            student.setName("丘婷婷"+i);
            student.setSex("女");
            student.setAge(27);
            list.add(student);
        }
        res = studentMapper.insertList(list);
        if (res>0){
            list.clear();
        }
        for (int i=0;i<10000;i++){
            Student student = new Student();
            student.setName("杰西"+i);
            student.setSex("女");
            student.setAge(27);
            list.add(student);
        }
        res = studentMapper.insertList(list);
        if (res>0){
            list.clear();
        }
        for (int i=0;i<10000;i++){
            Student student = new Student();
            student.setName("邓静"+i);
            student.setSex("女");
            student.setAge(27);
            list.add(student);
        }
        res = studentMapper.insertList(list);
        if (res>0){
            list.clear();
        }
        for (int i=0;i<10000;i++){
            Student student = new Student();
            student.setName("郭红艳"+i);
            student.setSex("女");
            student.setAge(27);
            list.add(student);
        }
        res = studentMapper.insertList(list);
        if (res>0){
            list.clear();
        }
        for (int i=0;i<10000;i++){
            Student student = new Student();
            student.setName("波波"+i);
            student.setSex("女");
            student.setAge(27);
            list.add(student);
        }
        res = studentMapper.insertList(list);
        if (res>0){
            list.clear();
        }
        return "生成成功";
    }

    public String addStudent(String name){
        List<Student> list = new ArrayList<>();
        for (int i=0;i<10000;i++){
            Student student = new Student();
            student.setName("范光福"+i);
            student.setSex("男");
            student.setAge(27);
            list.add(student);
        }
        int res = studentMapper.insertList(list);
        if (res>0){
            list.clear();
        }
        return "我爱你雪菲";
    }

    public void findAllDb(){
        List<Student> list = studentMapper.selectAll();
        List<Student> genList = new ArrayList<>();
        Student student;
        for (int i=0;i<5000;i++){
            student = new Student();
            student.setName("爱雪菲"+i);
            student.setAge(27);
            student.setSex("女");
            genList.add(student);
        }
        genList(genList,"赵情");
        genList(genList,"范光福");
        genList(genList,"杨雪菲");
        genList(genList,"刘月");
        for (int i=0;i<4960;i++){
            student = new Student();
            student.setName("爱赵情"+i);
            student.setAge(27);
            student.setSex("女");
            genList.add(student);
        }
        int cout = 0;
        long start = System.currentTimeMillis();
        System.out.println("对比前"+genList.size());
        for (Student s: genList) {
            String name = s.getName();
            if (ArrayListUtil.isInclude(list,name)){
                cout++;
            }
        }
        System.out.println("1重名"+cout);
        long end = System.currentTimeMillis();
        System.out.println(end-start);
        System.out.println(genList.size());
        ForkJoinPool fjp = new ForkJoinPool();
        DistinctTask task = new DistinctTask(0,genList.size(),list,genList);
        List<Student> resuList = fjp.invoke(task);
        System.out.println("2重名"+(resuList.size()));
        long end1 = System.currentTimeMillis();
        System.out.println(end1-end);
        System.out.println(genList.size());

    }

    private void genList(List<Student> genList,String name){
        Student student;
        for (int i=0;i<10;i++){
            student = new Student();
            student.setName(name+0);
            student.setAge(27);
            student.setSex("女");
            genList.add(student);
        }
    }

}
