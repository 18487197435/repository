package com.cn.fanguangfu.controller;

import com.cn.fanguangfu.service.StudentService;
import com.cn.fanguangfu.vo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.websocket.server.PathParam;

/**
 * @author Bangsun
 * @date 2020-11-26
 */
@Controller
@RequestMapping("/admin")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping("/find")
    @ResponseBody
    public String findStudent(){
        return "我想你杨雪菲";
    }

    @RequestMapping("/add")
    @ResponseBody
    public String addStudent(){
        return studentService.addStudent();
    }

    @RequestMapping("/add/name")
    @ResponseBody
    public String addStudent(@PathParam("name") String name){
        return studentService.addStudent(name);
    }

    @RequestMapping("/eq")
    @ResponseBody
    public String eqData(){
        studentService.findAllDb();
        return "对比结束";
    }

}
