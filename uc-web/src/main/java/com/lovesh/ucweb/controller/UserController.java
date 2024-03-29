package com.lovesh.ucweb.controller;

import com.lovesh.dto.Result;
import com.lovesh.ucweb.entity.User;
import com.lovesh.ucweb.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    private IUserService iUserService;

    @ResponseBody
    @GetMapping(value = "getAllUser")
    public Result<List<User>> getAllUser(){
        return iUserService.getAllUser();
    }


}
