package com.nabang97.bookrent.controller;

import com.nabang97.bookrent.configuration.jwt.JwtResponse;
import com.nabang97.bookrent.configuration.jwt.JwtUser;
import com.nabang97.bookrent.configuration.jwt.JwtUtils;
import com.nabang97.bookrent.dto.LoginData;
import com.nabang97.bookrent.dto.MemberData;
import com.nabang97.bookrent.dto.ResponseData;
import com.nabang97.bookrent.model.Address;
import com.nabang97.bookrent.model.JobDesc;
import com.nabang97.bookrent.model.Member;
import com.nabang97.bookrent.model.UserLogin;
import com.nabang97.bookrent.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by IntelliJ IDEA.
 * User         : Yolanda Parawita
 * Date & Time  : 18/06/2022 & 11:21
 */

@RestController @Slf4j
public class AuthenticationController {



    @Autowired
    JwtUtils jwtUtils;


    private final AuthenticationManager authenticationManager;

    public AuthenticationController(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginData loginData, Errors errors) {
        ResponseData<LoginData> responseData = new ResponseData<>();
        if (errors.hasErrors()) {
            for (ObjectError error : errors.getAllErrors()) {
                responseData.getMessages().add(error.getDefaultMessage());
            }
            responseData.setStatus(false);
            responseData.setPayload(null);
            return ResponseEntity.badRequest().body(responseData);
        }

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginData.getUsername(), loginData.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        JwtUser userDetails = (JwtUser) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());

        return ResponseEntity.ok(new JwtResponse(jwt,
                userDetails.getUsername(),
                roles));
    }

    @PostMapping("/authenticationcheck")
    public ResponseEntity<?> isUserAuthenticate(@RequestHeader (name="Authorization") String token) {
        Map<String, Object> map = new HashMap<>();
        map.put("isAuthenticated", false);
        map.put("username", "");
        System.out.println("Bearer toke : "+token);
        if (SecurityContextHolder.getContext().getAuthentication().isAuthenticated()){
            if (String.valueOf(SecurityContextHolder.getContext().getAuthentication()
                    .getPrincipal()).equals("anonymousUser")){
                map.put("isAuthenticated", false);
            }else{
                UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
                map.put("isAuthenticated", true);
                map.put("username", userDetails.getUsername());
            }
        }
        return ResponseEntity.ok().body(map);
    }


}
