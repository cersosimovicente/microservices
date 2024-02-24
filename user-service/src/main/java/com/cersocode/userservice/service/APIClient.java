package com.cersocode.userservice.service;

import com.cersocode.userservice.dto.DepartmentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "DEPARTMENT-SERVICE", url = "localhost:8080")
public interface APIClient {
    @GetMapping("/api/departments/{id}")
    DepartmentDto getDepartmentById(@PathVariable("id") Long departmentId);
}
