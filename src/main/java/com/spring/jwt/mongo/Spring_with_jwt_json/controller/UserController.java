package com.spring.jwt.mongo.Spring_with_jwt_json.controller;

import com.spring.jwt.mongo.Spring_with_jwt_json.model.User;
import com.spring.jwt.mongo.Spring_with_jwt_json.service.UserService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/saveUser")
    public String savingUser(@RequestBody User user){
        return userService.saveUser(user);
    }

    @GetMapping("/getUserDetails")
        public User getUserDetails(HttpServletRequest httpServletRequest){

        ObjectId userid = (ObjectId) httpServletRequest.getAttribute("userId");
        return userService.getUser(userid);

    }


}
