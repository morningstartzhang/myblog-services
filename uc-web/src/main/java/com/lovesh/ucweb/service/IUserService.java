package com.lovesh.ucweb.service;

import com.lovesh.dto.Result;
import com.lovesh.ucweb.entity.User;

import java.util.List;

public interface IUserService {
    /**
     * 获取所有用户
     *
     * @return {@link List}<{@link User}>
     */
    Result<List<User>> getAllUser();
}
