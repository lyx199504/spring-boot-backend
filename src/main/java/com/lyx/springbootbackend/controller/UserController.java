package com.lyx.springbootbackend.controller;

import com.lyx.springbootbackend.entity.User;
import com.lyx.springbootbackend.service.UserSerivce;
import com.lyx.springbootbackend.util.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
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
    public HttpResponse saveUser(User user) {
        try{
            this.userSerivce.save(user);
            return HttpResponse.success("添加用户成功",user);
        }catch (Exception e){
            return HttpResponse.failure(HttpResponse.SERVER_ERROR,e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public HttpResponse removeUser(@PathVariable Long id) {
        try{
            boolean remove = this.userSerivce.removeById(id);
            if (remove) {
                return HttpResponse.success("删除用户成功");
            } else {
                return HttpResponse.failure(HttpResponse.USER_ERROR,"该用户已删除");
            }
        }catch (Exception e){
            return HttpResponse.failure(HttpResponse.SERVER_ERROR,e.getMessage());
        }
    }

    @PutMapping
    public HttpResponse updateUser(User user) {
        try{
            boolean update = this.userSerivce.updateById(user);
            if (update) {
                return HttpResponse.success("修改用户成功",user);
            } else {
                return HttpResponse.failure(HttpResponse.USER_ERROR, "修改用户失败");
            }
        }catch (Exception e){
            return HttpResponse.failure(HttpResponse.SERVER_ERROR,e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public HttpResponse getUser(@PathVariable Long id) {
        try{
            User user = this.userSerivce.getById(id);
            if (user != null) {
                return HttpResponse.success("查询用户成功",user);
            } else {
                return HttpResponse.failure(HttpResponse.USER_ERROR,"查询用户失败");
            }
        }catch (Exception e){
            return HttpResponse.failure(HttpResponse.SERVER_ERROR,e.getMessage());
        }
    }

    @GetMapping
    public HttpResponse getUserList() {
        try{
            List<User> list = this.userSerivce.list();
            return HttpResponse.success("查询用户列表成功", list);
        }catch (Exception e){
            return HttpResponse.failure(HttpResponse.SERVER_ERROR,e.getMessage());
        }
    }
}
