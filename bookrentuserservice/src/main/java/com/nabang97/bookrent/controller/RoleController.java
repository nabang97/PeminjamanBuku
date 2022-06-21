package com.nabang97.bookrent.controller;

import com.nabang97.bookrent.dto.*;
import com.nabang97.bookrent.model.Role;
import com.nabang97.bookrent.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User         : Yolanda Parawita
 * Date & Time  : 20/06/2022 & 21:57
 */

@RestController
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping("/api/getroles")
    public List<Role> getRoles(){
        return roleService.getRoles();
    }

    @GetMapping("/api/getrole")
    public Role getRoles(@Valid @RequestBody OneRoleData roleData){
        return roleService.findRole(roleData.getId());
    }

    @RequestMapping("/api/editrole")
    public ResponseEntity<?> editRole(@Valid @RequestBody RoleData roleData, Errors errors){
        ResponseData<RoleData> responseData = new ResponseData<>();
        if (errors.hasErrors()) {
            for (ObjectError error : errors.getAllErrors()) {
                responseData.getMessages().add(error.getDefaultMessage());
            }
            responseData.setStatus(false);
            responseData.setPayload(null);
            return ResponseEntity.badRequest().body(responseData);
        }

        Role role = roleService.findRole(roleData.getId());
        role.setName(roleData.getName());
        roleService.save(role);

        responseData.setStatus(true);
        responseData.setPayload(roleData);
        return ResponseEntity.ok().body(responseData);
    }

    @RequestMapping("/api/addrole")
    public ResponseEntity<?> editRole(@Valid @RequestBody AddRoleData roleData, Errors errors){
        ResponseData<AddRoleData> responseData = new ResponseData<>();
        if (errors.hasErrors()) {
            for (ObjectError error : errors.getAllErrors()) {
                responseData.getMessages().add(error.getDefaultMessage());
            }
            responseData.setStatus(false);
            responseData.setPayload(null);
            return ResponseEntity.badRequest().body(responseData);
        }

        Role role = new Role();
        role.setName(roleData.getName());
        roleService.save(role);

        responseData.setStatus(true);
        responseData.setPayload(roleData);
        return ResponseEntity.ok().body(responseData);
    }
}
