package com.lyx.springbootbackend.controller;

import com.lyx.springbootbackend.entity.User;
import com.lyx.springbootbackend.service.UserSerivce;
import com.lyx.springbootbackend.util.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author LYX-夜光
 * @date 2020/6/22
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserSerivce userSerivce;

    @PostMapping
    public HttpStatus saveUser(User user) {
        HttpStatus status = new HttpStatus();
        try{
            this.userSerivce.save(user);
            status.setHttpStatus(HttpStatus.success,"添加用户成功",user);
            return status;
        }catch (Exception e){
            status.setHttpStatus(HttpStatus.serverError,e.getMessage(),null);
            return status;
        }
    }

    @DeleteMapping("/{id}")
    public HttpStatus removeUser(@PathVariable Long id) {
        HttpStatus status = new HttpStatus();
        try{
            boolean remove = this.userSerivce.removeById(id);
            if (remove) {
                status.setHttpStatus(HttpStatus.success,"删除用户成功",null);
            } else {
                status.setHttpStatus(HttpStatus.userError,"该用户已删除",null);
            }
            return status;
        }catch (Exception e){
            status.setHttpStatus(HttpStatus.serverError,e.getMessage(),null);
            return status;
        }
    }

    @PutMapping
    public HttpStatus updateUser(User user) {
        HttpStatus status = new HttpStatus();
        try{
            this.userSerivce.updateById(user);
            status.setHttpStatus(HttpStatus.success,"修改用户成功",user);
            return status;
        }catch (Exception e){
            status.setHttpStatus(HttpStatus.serverError,e.getMessage(),null);
            return status;
        }
    }

    @GetMapping("/{id}")
    public HttpStatus getUser(@PathVariable Long id) {
        HttpStatus status = new HttpStatus();
        try{
            User user = this.userSerivce.getById(id);
            if (user != null) {
                status.setHttpStatus(HttpStatus.success,"查询用户成功",user);
            } else {
                status.setHttpStatus(HttpStatus.userError,"查询用户失败",user);
            }
            return status;
        }catch (Exception e){
            status.setHttpStatus(HttpStatus.serverError,e.getMessage(),null);
            return status;
        }
    }

    @GetMapping
    public HttpStatus getUserList() {
        HttpStatus status = new HttpStatus();
        try{
            List<User> list = this.userSerivce.list();
            status.setHttpStatus(HttpStatus.success,"查询用户列表成功", list);
            return status;
        }catch (Exception e){
            status.setHttpStatus(HttpStatus.serverError,e.getMessage(),null);
            return status;
        }
    }
}
