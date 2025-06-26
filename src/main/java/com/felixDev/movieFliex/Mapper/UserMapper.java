package com.felixDev.movieFliex.Mapper;

import com.felixDev.movieFliex.Controller.Request.UserRecord;
import com.felixDev.movieFliex.Controller.Response.UserResponse;
import com.felixDev.movieFliex.Entity.Users;
import lombok.experimental.UtilityClass;
import org.springframework.boot.autoconfigure.security.SecurityProperties;

@UtilityClass
public class UserMapper {

    public static Users toUser(UserRecord userRecord){
        return Users.builder()
                .email(userRecord.email())
                .name(userRecord.name())
                .password(userRecord.password())
                .build();
    }

    public static UserResponse toUserResponse(Users users){
        return UserResponse.builder()
                .id(users.getId())
                .name(users.getName())
                .email(users.getEmail())
                .build();
    }
}
