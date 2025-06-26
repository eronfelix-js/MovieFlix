package com.felixDev.movieFliex.Controller;

import com.felixDev.movieFliex.Config.TokenConfig;
import com.felixDev.movieFliex.Controller.Request.UserRecord;
import com.felixDev.movieFliex.Controller.Response.TokenResponse;
import com.felixDev.movieFliex.Controller.Response.UserResponse;
import com.felixDev.movieFliex.Eception.UsernameOrPasswordException;
import com.felixDev.movieFliex.Entity.Users;
import com.felixDev.movieFliex.Mapper.UserMapper;
import com.felixDev.movieFliex.Service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movieflix/auth")
@RequiredArgsConstructor
public class AuthController {

    @Autowired
    private final UsersService usersService;
    private final AuthenticationManager authenticationManager;
    private final TokenConfig tokenConfig;

    @PostMapping("/criar")
    public ResponseEntity<UserResponse> criar(@RequestBody UserRecord request) {
        Users salvar = usersService.salvar(UserMapper.toUser(request));
        return ResponseEntity.status(HttpStatus.CREATED).body(UserMapper.toUserResponse(salvar));
    }

    @PostMapping("/login")
    public ResponseEntity<TokenResponse> login(@RequestBody UserRecord request) {

        try {
            UsernamePasswordAuthenticationToken userPass = UsernamePasswordAuthenticationToken.unauthenticated(request.email(), request.password());
            Authentication authenticate = authenticationManager.authenticate(userPass);
            Users users = (Users) authenticate.getPrincipal();

            String token = tokenConfig.generateToken(users);

            return ResponseEntity.ok(new TokenResponse(token));
        }
        catch (BadCredentialsException e) {
            throw new UsernameOrPasswordException("Usuario ou senha invalida");
        }

    }


}
