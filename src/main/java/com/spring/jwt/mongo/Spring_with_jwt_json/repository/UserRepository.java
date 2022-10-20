package com.spring.jwt.mongo.Spring_with_jwt_json.repository;

import com.spring.jwt.mongo.Spring_with_jwt_json.model.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, ObjectId> {

}
