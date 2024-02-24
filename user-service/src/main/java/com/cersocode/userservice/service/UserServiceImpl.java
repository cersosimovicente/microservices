package com.cersocode.userservice.service;

import com.cersocode.userservice.dto.DepartmentDto;
import com.cersocode.userservice.dto.ResponseDto;
import com.cersocode.userservice.dto.UserDto;
import com.cersocode.userservice.entity.User;
import com.cersocode.userservice.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;


@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;
   // private RestTemplate restTemplate;
    private WebClient webClient;

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public ResponseDto getUser(Long userId) {
        ResponseDto responseDto = new ResponseDto();
        User user = userRepository.findById(userId).get();
        UserDto userDto = mapToUser(user);

//        ResponseEntity<DepartmentDto>  responseEntity = restTemplate
//                .getForEntity("http://localhost:8080/api/departments/" + user.getDepartmentId(),
//                DepartmentDto.class);

//        DepartmentDto departmentDto = responseEntity.getBody();
//        System.out.println(responseEntity.getStatusCode());
//        responseDto.setUserDto(userDto);
//        responseDto.setDepartmentDto(departmentDto);

        DepartmentDto departmentDto = webClient.get()
                .uri("http://localhost:8080/api/departments/" + user.getDepartmentId())
                .retrieve()
                .bodyToMono(DepartmentDto.class)
                .block();
        responseDto.setUser(userDto);
        responseDto.setDepartment(departmentDto);

        return responseDto;
    }

    private UserDto mapToUser(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setEmail(user.getEmail());
        return userDto;
    }
}
