package com.nabang97.bookrent.configuration.jwt;

import com.nabang97.bookrent.model.Role;
import com.nabang97.bookrent.model.UserLogin;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by IntelliJ IDEA.
 * User         : Yolanda Parawita
 * Date & Time  : 18/06/2022 & 20:07
 */

public final class JwtUserFactory {

    private JwtUserFactory() {
    }

    public static JwtUser create(UserLogin user) {
        return new JwtUser(
                user.getUsername(),
                user.getPassword(),
                mapToGrantedAuthorities((List<Role>) user.getRoles()),
                user.getEnabled()
        );
    }

    private static List<GrantedAuthority> mapToGrantedAuthorities(List<Role> roles) {
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());
    }
}
