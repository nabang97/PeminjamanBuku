package com.nabang97.bookrent.repository;

import com.nabang97.bookrent.model.Role;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by IntelliJ IDEA.
 * User         : Yolanda Parawita
 * Date & Time  : 18/06/2022 & 18:12
 */

public interface RoleRepository extends CrudRepository<Role,Integer> {

    Role findFirstByName(String name);

}
