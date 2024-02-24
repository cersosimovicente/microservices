package com.cersocode.userservice.service;

import com.cersocode.userservice.dto.ResponseDto;
import com.cersocode.userservice.entity.User;

public interface UserService {
    User saveUser(User user);
    ResponseDto getUser(Long userId);
}
