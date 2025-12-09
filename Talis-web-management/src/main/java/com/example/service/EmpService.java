package com.example.service;


import com.example.pojo.Emp;
import com.example.pojo.EmpQueryParam;
import com.example.pojo.Logininfo;
import com.example.pojo.PageResult;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public interface EmpService {

    PageResult<Emp> findAll(EmpQueryParam empQueryParam);

    void save(Emp emp);

    void delete(List<Integer> ids);

    void update(Emp emp);

    Emp getInfo(Integer id);

    List<Emp> list();

    Logininfo login(Emp emp);
}
