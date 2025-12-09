package com.example.service;


import com.example.pojo.Clazz;
import com.example.pojo.ClazzQueryParam;
import com.example.pojo.PageResult;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ClazzService {
    PageResult<Clazz> list(ClazzQueryParam clazzQueryParam);

    void insert(Clazz clazz);

    Clazz findById(Integer id);

    void update(Clazz clazz);

    void deleteById(Integer id);

    List<Clazz> listAll();
}
