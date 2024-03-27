package com.lovesh.ucweb.service.Impl;

import com.lovesh.dto.Result;
import com.lovesh.ucweb.dao.UserMapper;
import com.lovesh.ucweb.entity.User;
import com.lovesh.ucweb.service.IUserService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class UserServiceImpl implements IUserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public Result<List<User>> getAllUser(){
        List<User> list = userMapper.selectList(null);
        return new Result<>(list);
    }
}
