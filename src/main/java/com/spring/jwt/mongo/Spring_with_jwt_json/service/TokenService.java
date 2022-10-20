package com.spring.jwt.mongo.Spring_with_jwt_json.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.Date;

@Service
public class TokenService {
    public static final String Token_Secret = "abc123";

    public String createToken(ObjectId userid) {
        try {
            //Random generating string using token secret
            // using HMAC256 algorithm to generate token
            Algorithm algorithm = Algorithm.HMAC256(Token_Secret);

            //using claims of userId and created Date using Date Object
            String token = JWT.create()
                    .withClaim("userId", userid.toString())
                    .withClaim("createdAt", new Date())
                    .sign(algorithm);
            return token;

        } catch (UnsupportedEncodingException exception) {
            exception.printStackTrace();
        } catch (JWTCreationException exception) {
            exception.printStackTrace();
        }
        return null;

    }

    public String getUserIdFromToken(String token) {
        try{
        //Random generating string using token secret , using HMAC256 algorithm to generate token
        Algorithm algorithm = Algorithm.HMAC256(Token_Secret);
        JWTVerifier jwtVerifier = JWT.require(algorithm).build();
        DecodedJWT decodedJWT = jwtVerifier.verify(token);

        return decodedJWT.getClaim("userId").asString();

    }
    catch(UnsupportedEncodingException exception)
    {
        exception.printStackTrace();
    }
    catch(JWTCreationException exception)
    {
        exception.printStackTrace();
    }
    return null;
  }

  public boolean isTokenValid(String token)
  {
    String userid = this.getUserIdFromToken(token);
    return userid != null;
  }

}
