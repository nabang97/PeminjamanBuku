package com.nabang97.bookrent.controller;

import com.nabang97.bookrent.dto.LibrarianData;
import com.nabang97.bookrent.dto.MemberData;
import com.nabang97.bookrent.dto.ResponseData;
import com.nabang97.bookrent.model.*;
import com.nabang97.bookrent.services.AddressService;
import com.nabang97.bookrent.services.LibrarianService;
import com.nabang97.bookrent.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User         : Yolanda Parawita
 * Date & Time  : 20/06/2022 & 20:43
 */
@RestController
public class LibrarianController {

    @Autowired
    private UserService userService;

    @Autowired
    private LibrarianService librarianService;

    @Autowired
    private AddressService addressService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @RequestMapping("/api/createuser")
    public ResponseEntity<ResponseData<Librarian>> create(@Valid @RequestBody LibrarianData librarianData, Errors errors) throws ParseException {
        ResponseData<Librarian> responseData = new ResponseData<>();
        if (errors.hasErrors()) {
            for (ObjectError error : errors.getAllErrors()) {
                responseData.getMessages().add(error.getDefaultMessage());
            }
            responseData.setStatus(false);
            responseData.setPayload(null);
            return ResponseEntity.badRequest().body(responseData);
        }

        if (librarianService.isIdentityExist(librarianData.getIdentityNumber())) {
            responseData.setStatus(false);
            responseData.setPayload(null);
            responseData.getMessages().add("Error: Identity is already in use!");
            return ResponseEntity
                    .badRequest()
                    .body(responseData);
        }

        if (librarianService.isEmailExist(librarianData.getEmail())) {
            responseData.setStatus(false);
            responseData.setPayload(null);
            responseData.getMessages().add("Error: Email is already in use!");
            return ResponseEntity
                    .badRequest()
                    .body(responseData);
        }

        Address homeAddress = new Address();
        homeAddress.setId(librarianData.getNip()+new Date().getTime()+"H");
        homeAddress.setAddress(librarianData.getAddressHome());
        homeAddress.setVillage(librarianData.getVillageHome());
        homeAddress.setSubDistrict(librarianData.getSubDistrictHome());
        homeAddress.setCity(librarianData.getCityHome());
        homeAddress.setZipCode(librarianData.getZipCodeHome());
        addressService.saveAddress(homeAddress);

        try {
            UserLogin userLogin = new UserLogin();
            userLogin.setEnabled(true);
            userLogin.setUsername(librarianData.getNip());
            userLogin.setPassword(passwordEncoder.encode(librarianData.getPassword()));
            userLogin.setGroupUser("LIBRARIAN");
            userService.addRoletoUser(userLogin, librarianData.getRole());
            System.out.println(userLogin);
            userLogin.setLastLogin(new Date());
            userService.saveLogin(userLogin);
        }catch (Exception e){
            responseData.setStatus(false);
            responseData.setPayload(null);
            responseData.getMessages().add("Error: "+e.getMessage());
            return ResponseEntity
                    .badRequest()
                    .body(responseData);
        }

        responseData.setStatus(true);
        responseData.setPayload(null);
        responseData.getMessages().add("Data has been created successfully");

        return ResponseEntity.status(HttpStatus.CREATED).body(responseData);
    }
}
