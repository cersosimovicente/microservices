package com.cersocode.userservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ResponseDto {
    private DepartmentDto departmentDto;
    private UserDto userDto;
}
