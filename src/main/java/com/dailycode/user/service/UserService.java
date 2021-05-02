package com.dailycode.user.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.dailycode.user.entity.User;
import com.dailycode.user.repository.UserRepository;
import com.dailycode.user.wrapper.Department;
import com.dailycode.user.wrapper.UserDepartmentWrapper;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    public User saveUser(User user) {
        log.info("Inside saveUser of UserService");
        return userRepository.save(user);
    }

    public UserDepartmentWrapper getUserWithDepartment(Long userId) {
        log.info("Inside getUserWithDepartment of UserService");
        UserDepartmentWrapper userDepartmentWrapper = new UserDepartmentWrapper();
        User user = userRepository.findByUserId(userId);

        Department department =
                restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/" + user.getDepartmentId()
                        ,Department.class);

        userDepartmentWrapper.setUser(user);
        userDepartmentWrapper.setDepartment(department);

        return  userDepartmentWrapper;
    }
}
