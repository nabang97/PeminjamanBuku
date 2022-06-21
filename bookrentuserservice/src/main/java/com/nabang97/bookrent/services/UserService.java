package com.nabang97.bookrent.services;

import com.nabang97.bookrent.configuration.jwt.JwtUserFactory;
import com.nabang97.bookrent.model.*;
import com.nabang97.bookrent.repository.*;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * Created by IntelliJ IDEA.
 * User         : Yolanda Parawita
 * Date & Time  : 18/06/2022 & 10:18
 */

@Service @RequiredArgsConstructor @Transactional
public class UserService implements UserDetailsService {


    @Autowired
    private UserLoginRespository userLoginRespository;


    @Autowired
    private RoleRepository roleRepository;


    public UserLogin saveLogin(UserLogin userLogin){
        return userLoginRespository.save(userLogin);
    }

    public UserLogin addRoletoUser(UserLogin user, String roleName) {
        Role role = roleRepository.findFirstByName(roleName);
        System.out.println(user);
        System.out.println(role);
        user.getRoles().add(role);
        return user;
    }

    public List<UserLogin> getUsers() {
        return (List<UserLogin>) userLoginRespository.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserLogin user = userLoginRespository.findFirstByUsername(username);
        if (user == null)
            throw new UsernameNotFoundException("user not found");

        return JwtUserFactory.create(user);
    }
}
