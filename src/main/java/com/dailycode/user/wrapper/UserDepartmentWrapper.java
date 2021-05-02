package com.dailycode.user.wrapper;

import com.dailycode.user.entity.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDepartmentWrapper {

    private User user;
    private Department department;
}
