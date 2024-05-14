package com.example.TransactionalOutBoxPattern.UserMapper;

import com.example.TransactionalOutBoxPattern.dto.Department;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DepartmentMapper {

    @Insert("INSERT INTO department(department_id, department_name) " +
            "VALUES(#{department_id}, #{department_name})")
    void insertDepartment(Department department);

    @Select("SELECT * FROM department WHERE department_id = #{departmentId}")
    List<Department> getDepartment(String departmentId);

}
