package com.spring.jwt.mongo.Spring_with_jwt_json.service;

import com.spring.jwt.mongo.Spring_with_jwt_json.model.User;
import com.spring.jwt.mongo.Spring_with_jwt_json.repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {


    private UserRepository userRepository;
    private TokenService tokenService;

    @Autowired
    public UserService(UserRepository userRepository, TokenService tokenService) {
        this.userRepository = userRepository;
        this.tokenService = tokenService;
    }


    public User getUser(ObjectId userId){
        Optional<User> optionalUser = userRepository.findById(userId);
        return optionalUser.orElseGet(optionalUser::get);
    }

    public String saveUser(User user){

        User savedUser = userRepository.save(user);
        return "{" + "\"message\":"+
                "\"Successfully Created User\","+
                "\"data\": "
                +savedUser+", "+
                "\"token\":\""+
                tokenService.createToken(savedUser.getId())+
                "\"}";
    }



//    public User getUser(ObjectId id){
//        Optional<User> result = userRepository.findOne(new Example<User>() {
//            @Override
//            public User getProbe() {
//                return null;
//            }
//
//            @Override
//            public ExampleMatcher getMatcher() {
//                return null;
//            }
//        });
//
//        return result.get();
//    }




}
