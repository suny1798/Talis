package com.example.controller;


import com.example.pojo.Clazz;
import com.example.pojo.ClazzQueryParam;
import com.example.pojo.PageResult;
import com.example.pojo.Result;
import com.example.service.ClazzService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/clazzs")
public class ClazzController {

    @Autowired
    private ClazzService clazzService;

    @GetMapping
    public Result list(ClazzQueryParam clazzQueryParam){
        log.info("查询全部班级信息");
        PageResult<Clazz> pageResult = clazzService.list(clazzQueryParam);
        return Result.success(pageResult);
    }

    @GetMapping("/list")
    public Result listAll(){
        log.info("查询全部班级列表");
        List<Clazz> list = clazzService.listAll();
        return Result.success(list);
    }

    @PostMapping
    public Result save(@RequestBody Clazz clazz){
        log.info("添加班级信息: {}", clazz);
        clazzService.insert(clazz);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result getInfo(@PathVariable Integer id){
        log.info("查询班级id信息: {}", id);
        Clazz clazz = clazzService.findById(id);
        return Result.success(clazz);
    }

    @PutMapping
    public Result update(@RequestBody Clazz clazz){
        log.info("修改班级信息: {}", clazz);
        clazzService.update(clazz);
        return Result.success();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        log.info("删除班级id信息: {}", id);
        clazzService.deleteById(id);
        return Result.success();
    }
}
