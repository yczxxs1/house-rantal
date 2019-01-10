package com.netflix.houserental.business.controller;

import com.netflix.houserental.business.form.RegisterForm;
import com.netflix.houserental.business.model.User;
import com.netflix.houserental.business.service.UserService;
import com.netflix.houserental.common.result.ResultUtil;
import com.netflix.houserental.common.result.ResultVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotEmpty;

@RestController
@RequestMapping("user")
@Api(tags = "用户")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    @ApiOperation(value = "登录")
    public ResultVo<User> login(@ApiParam("用户名") @RequestParam String userName, @ApiParam("密码") @RequestParam String password) {
        return ResultUtil.success(userService.login(userName, password));
    }


    @PostMapping("/register")
    @ApiOperation(value = "注册")
    public ResultVo<String> register(@Validated RegisterForm user) {
        userService.register(user);
        return ResultUtil.success();
    }

}
