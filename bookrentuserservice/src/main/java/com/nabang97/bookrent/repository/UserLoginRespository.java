package com.nabang97.bookrent.repository;

import com.nabang97.bookrent.model.UserLogin;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created by IntelliJ IDEA.
 * User         : Yolanda Parawita
 * Date & Time  : 18/06/2022 & 10:33
 */

public interface UserLoginRespository extends CrudRepository<UserLogin, String> {
    UserLogin findFirstByUsername(String username);
    Boolean existsByUsername(String username);
}
