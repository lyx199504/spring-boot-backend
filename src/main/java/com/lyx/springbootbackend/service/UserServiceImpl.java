package com.lyx.springbootbackend.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lyx.springbootbackend.entity.User;
import com.lyx.springbootbackend.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
 * @author LYX-夜光
 * @date 2020/6/22
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserSerivce {
}
