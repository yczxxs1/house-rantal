package com.netflix.houserental.business.service;

import com.netflix.houserental.business.exception.UserNotFoundException;
import com.netflix.houserental.business.form.RegisterForm;
import com.netflix.houserental.business.model.User;

public interface UserService {
    User login(String username, String password) throws UserNotFoundException;

    void register(RegisterForm user) ;
}
