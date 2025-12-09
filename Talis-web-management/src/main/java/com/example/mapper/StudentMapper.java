package com.example.mapper;


import com.example.pojo.ClazzOption;
import com.example.pojo.PageResult;
import com.example.pojo.StuQueryParm;
import com.example.pojo.Student;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface StudentMapper {

    @Select("select * from student order by update_time desc")
    List<Student> list();

    List<Student> page(StuQueryParm studentQueryParam);

    void insert(Student student);

    @Select("select * from student where id = #{id}")
    Student findById(Integer id);

    void update(Student student);

    void deleteById(Integer id);

    void addViolation(Integer id, Short score);

    @MapKey("degree")
    List<Map<String, Object>> getStudentDegreeData();

    @MapKey("name")
    List<Map<String, Object>> countStudentCountData();
}
