package com.cersocode.departmentservice.service;

import com.cersocode.departmentservice.entity.Department;

public interface DepartmentService {
    Department saveDepartment(Department department);
    Department getDepartmentById(Long departmentId);
}
