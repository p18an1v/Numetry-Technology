package com.example.ems.mapper;

import com.example.ems.dto.DepartmentDto;
import com.example.ems.entity.Department;

public class DepartmentMapper {

    //convert department jpa entity to department dto
    public static DepartmentDto mapToDepartmentDto(Department department) {
        return new DepartmentDto(
                department.getId(),
                department.getDepartmentName(),
                department.getDepartmentDescription()
        );
    }

    //convert department dto to department jpa entity
    public static Department mapToDepartment(DepartmentDto departmentDto){
        return new Department(
                departmentDto.getId(),
                departmentDto.getDepartmentName(),
                departmentDto.getDepartmentDescription()
        );
    }

}
