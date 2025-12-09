package com.example.mapper;


import com.example.pojo.Clazz;
import com.example.pojo.ClazzQueryParam;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ClazzMapper {

    List<Clazz> list(ClazzQueryParam clazzQueryParam);


    @Insert("INSERT INTO clazz (name, room, begin_date, end_date, master_id, subject, create_time, update_time)" +
            "VALUES (#{name}, #{room}, #{beginDate}, #{endDate}, #{masterId}, #{subject}, #{createTime}, #{updateTime})")
    void insert(Clazz clazz);

    @Select("SELECT id, name, room, begin_date, end_date, master_id, subject, create_time, update_time FROM clazz WHERE id = #{id}")
    Clazz findById(Integer id);

    @Update("UPDATE clazz SET name = #{name}, room = #{room}, begin_date = #{beginDate}, end_date = #{endDate}, master_id = #{masterId}, subject = #{subject} where id = #{id}")
    void update(Clazz clazz);

    @Delete("DELETE FROM clazz WHERE id = #{id}")
    void deleteById(Integer id);

    @Select("SELECT * FROM clazz")
    List<Clazz> listAll();
}
