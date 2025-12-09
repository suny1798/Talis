package com.example.controller;

import com.example.pojo.PageResult;
import com.example.pojo.Result;
import com.example.pojo.StuQueryParm;
import com.example.pojo.Student;
import com.example.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Slf4j
@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/list")
    public Result list(){
        log.info("查询全部学生信息");
        List<Student> list = studentService.list();
        return Result.success(list);
    }

    @GetMapping
    public Result page(StuQueryParm studentQueryParam){
        log.info("分页查询学生信息, {}", studentQueryParam);
        PageResult<Student> pageResult = studentService.page(studentQueryParam);
        return Result.success(pageResult);
    }

    @PostMapping
    public Result insert(@RequestBody Student student){
        log.info("新增学生信息: {}", student);
        studentService.insert(student);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result findById(@PathVariable Integer id){
        log.info("查询学生信息: {}", id);
        Student student = studentService.findById(id);
        return Result.success(student);
    }

    @PutMapping
    public  Result update(@RequestBody Student student){
        log.info("更新学生信息: {}", student);
        studentService.update(student);
        return Result.success();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        log.info("删除学生信息: {}", id);
        studentService.deleteById(id);
        return Result.success();
    }

    @PutMapping("/violation/{id}/{score}")
    public Result addViolation(@PathVariable Integer id, @PathVariable Short score){
        log.info("添加学生违规信息: {}, {}", id, score);
        studentService.addViolation(id, score);
        return Result.success();
    }

}
