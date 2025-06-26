package com.felixDev.movieFliex.Service;

import com.felixDev.movieFliex.Entity.Users;
import com.felixDev.movieFliex.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsersService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public Users salvar(Users users){
        String password = users.getPassword();
        users.setPassword(passwordEncoder.encode(password));
        return userRepository.save(users);
    }

}
