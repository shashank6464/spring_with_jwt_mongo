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

    @Autowired
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUser(ObjectId userId){
        Optional<User> optionalUser = userRepository.findById(userId);
        return optionalUser.orElseGet(optionalUser::get);
    }

    public String saveUser(User user){

        userRepository.save(user);
        return "Successfully created user";
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
