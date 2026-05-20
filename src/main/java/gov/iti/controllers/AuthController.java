package gov.iti.controllers;


import gov.iti.config.TokenGenerator;
import gov.iti.config.UserManager;
import gov.iti.dto.Token;
import gov.iti.dto.UserSignInDTO;
import gov.iti.dto.UserSignUpDTO;
import gov.iti.entity.User;
import gov.iti.mappers.UserMapper;
import gov.iti.repo.UserRepo;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
@Tag(name = "Authentication", description = "User authentication, registration  token Generation")
public class AuthController {
    @Autowired
    UserManager userDetailsManager;
    @Autowired
    TokenGenerator tokenGenerator;
    @Autowired
    DaoAuthenticationProvider daoAuthenticationProvider;
    @Autowired
    UserMapper userMapper;

    @Autowired
    UserRepo userRepo;


    @PostMapping(path = "/register", produces = "application/json")
    public ResponseEntity<Token> register(@RequestBody @Valid UserSignUpDTO signupDTO, HttpServletResponse response) throws Exception {
        User user = userMapper.toUserFromSignUp(signupDTO);
        user = userDetailsManager.createUser(user);

        Authentication authentication = UsernamePasswordAuthenticationToken.authenticated(user, signupDTO.getPassword(), Arrays.asList(new SimpleGrantedAuthority("ROLE_USER")));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        Token token = tokenGenerator.createToken(user);


        return ResponseEntity.ok(token);
    }



    @PostMapping(path = "/login", produces = "application/json")
    public ResponseEntity<Token> login(@RequestBody @Valid UserSignInDTO loginDTO, HttpServletResponse response) {
        Authentication authentication = daoAuthenticationProvider.authenticate(UsernamePasswordAuthenticationToken.unauthenticated(loginDTO.getUserName(), loginDTO.getPassword()));

        Token token = tokenGenerator.createToken(userRepo.findByUserName(authentication.getName()).get());

        return ResponseEntity.ok(token);
    }


}
