package com.netflix.houserental.business.service.impl;

import com.netflix.houserental.business.condition.Condition;
import com.netflix.houserental.business.dao.UserMapper;
import com.netflix.houserental.business.exception.UserNotFoundException;
import com.netflix.houserental.business.form.RegisterForm;
import com.netflix.houserental.business.model.User;
import com.netflix.houserental.business.service.UserService;
import com.netflix.houserental.common.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public User login(String username, String password) throws UserNotFoundException {
        Condition condition=new Condition();
        condition.setUserName(username);
        condition.setPassword(password);
        User user=userMapper.selectByUsernameAndPass(condition);
        if(user==null)
            throw new ServiceException("用户名或密码不正确！");
        return user;
    }

    @Override
    public void register(RegisterForm form) {
        String username=form.getUserName();
        String password=form.getPassword();
        //校验用户名是否存在
        Condition condition=new Condition();
        condition.setUserName(username);
        condition.setPassword(password);
        User user=userMapper.selectByUsernameAndPass(condition);
        if(user!=null)
            throw new ServiceException("该用户已经存在！");
        //落表
        user=new User(form.getUserName(),form.getPassword());
        userMapper.insert(user);



    }
}
