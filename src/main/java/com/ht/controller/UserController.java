package com.ht.controller;

import com.ht.entity.User;
import com.ht.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @auth Qiu
 * @time 2018/3/6
 **/
@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("getList/{id}")
    @ResponseBody
    public Object getList(@PathVariable("id")Long id){
        System.out.println("123");
        Object object=userService.getById(id);

        return object==null?null:object;
    }

}
