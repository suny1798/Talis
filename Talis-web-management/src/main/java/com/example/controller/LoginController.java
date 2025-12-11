package com.example.controller;

import com.example.anno.LoginOperation;
import com.example.pojo.Emp;
import com.example.pojo.Logininfo;
import com.example.pojo.Result;
import com.example.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
public class LoginController {

    @Autowired
    private EmpService empService;

    @PostMapping("/login")
    public Result login(@RequestBody Emp emp){
        log.info("登录： {}", emp);
        Logininfo logininfo = empService.login(emp);
        if (logininfo != null) {
            return Result.success(logininfo);
        }
        return Result.error("用户名或密码错误");
    }

}
