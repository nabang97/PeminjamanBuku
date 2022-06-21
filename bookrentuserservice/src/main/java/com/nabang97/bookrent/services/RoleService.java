package com.nabang97.bookrent.services;

import com.nabang97.bookrent.model.Role;
import com.nabang97.bookrent.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by IntelliJ IDEA.
 * User         : Yolanda Parawita
 * Date & Time  : 20/06/2022 & 20:46
 */

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;


    public Role save(Role role){
        return roleRepository.save(role);
    }

    public Role findRole(int id){
        Optional role = roleRepository.findById(id);
        if (role.isPresent())
            return (Role) role.get();

        return null;
    }

    public List<Role> getRoles(){
        return (List<Role>) roleRepository.findAll();
    }

}
