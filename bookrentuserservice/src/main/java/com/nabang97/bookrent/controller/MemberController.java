package com.nabang97.bookrent.controller;

import com.nabang97.bookrent.dto.*;
import com.nabang97.bookrent.model.Address;
import com.nabang97.bookrent.model.JobDesc;
import com.nabang97.bookrent.model.Member;
import com.nabang97.bookrent.model.UserLogin;
import com.nabang97.bookrent.services.AddressService;
import com.nabang97.bookrent.services.JobDescService;
import com.nabang97.bookrent.services.MemberService;
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
public class MemberController {

    @Autowired
    private UserService userService;

    @Autowired
    private MemberService memberService;

    @Autowired
    private AddressService addressService;

    @Autowired
    private JobDescService jobDescService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @RequestMapping("/api/registration")
    public ResponseEntity<ResponseData<Member>> create(@Valid @RequestBody MemberData memberData, Errors errors) throws ParseException {
        ResponseData<Member> responseData = new ResponseData<>();
        if (errors.hasErrors()) {
            for (ObjectError error : errors.getAllErrors()) {
                responseData.getMessages().add(error.getDefaultMessage());
            }
            responseData.setStatus(false);
            responseData.setPayload(null);
            return ResponseEntity.badRequest().body(responseData);
        }

        if (memberService.isIdentityExist(memberData.getIdentityNumber())) {
            responseData.setStatus(false);
            responseData.setPayload(null);
            responseData.getMessages().add("Error: Identity is already in use!");
            return ResponseEntity
                    .badRequest()
                    .body(responseData);
        }

        if (memberService.isEmailExist(memberData.getEmail())) {
            responseData.setStatus(false);
            responseData.setPayload(null);
            responseData.getMessages().add("Error: Email is already in use!");
            return ResponseEntity
                    .badRequest()
                    .body(responseData);
        }

        String memberNumber = memberService.getMemberNumber();
        Address homeAddress = new Address();
        homeAddress.setId(memberNumber+new Date().getTime()+"H");
        homeAddress.setAddress(memberData.getAddressHome());
        homeAddress.setVillage(memberData.getVillageHome());
        homeAddress.setSubDistrict(memberData.getSubDistrictHome());
        homeAddress.setCity(memberData.getCityHome());
        homeAddress.setZipCode(memberData.getZipCodeHome());
        addressService.saveAddress(homeAddress);

        Address instituteAddress = new Address();
        instituteAddress.setId(memberNumber+new Date().getTime()+"C");
        instituteAddress.setAddress(memberData.getAddressInst());
        instituteAddress.setVillage(memberData.getVillageInst());
        instituteAddress.setSubDistrict(memberData.getSubDistrictInst());
        instituteAddress.setCity(memberData.getCityInst());
        instituteAddress.setZipCode(memberData.getZipCodeInst());
        addressService.saveAddress(instituteAddress);

        JobDesc jobDesc = new JobDesc();
        jobDesc.setId(memberNumber+new Date().getTime());
        jobDesc.setInstituteName(memberData.getInstitutePhone());
        jobDesc.setJob(memberData.getJob());
        jobDesc.setInstitutePhone(memberData.getInstitutePhone());
        jobDesc.setAddress(instituteAddress);
        jobDescService.saveJob(jobDesc);

        Member member = new Member();
        member.setEmail(memberData.getEmail());
        member.setIdentityNumber(memberData.getIdentityNumber());
        member.setDateOfBirth(new SimpleDateFormat("yyyy-MM-dd").parse(memberData.getDateOfBirth()));
        member.setFullName(memberData.getFullName());
        member.setGender(memberData.getGender());
        member.setMemberSince(new Date());
        member.setHomeAddress(homeAddress);
        member.setJob(jobDesc);
        member.setLastEducation(memberData.getLastEducation());
        member.setPhoneNumber(memberData.getPhoneNumber());
        member.setMaritalStatus(memberData.getMaritalStatus());
        member.setPlaceOfBirth(memberData.getPlaceOfBirth());
        member.setTelephoneNumber(memberData.getTelephoneNumber());
        member.setMemberNumber(memberNumber);
        memberService.save(member);

        try {
            UserLogin userLogin = new UserLogin();
            userLogin.setEnabled(true);
            userLogin.setUsername(memberNumber);
            userLogin.setPassword(passwordEncoder.encode(memberData.getPassword()));
            userLogin.setGroupUser("MEMBER");
            userService.addRoletoUser(userLogin, memberData.getRole());
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

    @RequestMapping("/api/edithomeaddress")
    public ResponseEntity<?> editHomeAddress(@Valid @RequestBody AddressData addressData, Errors errors){
        ResponseData<AddressData> responseData = new ResponseData<>();
        if (errors.hasErrors()) {
            for (ObjectError error : errors.getAllErrors()) {
                responseData.getMessages().add(error.getDefaultMessage());
            }
            responseData.setStatus(false);
            responseData.setPayload(null);
            return ResponseEntity.badRequest().body(responseData);
        }

        Address address = addressService.findOneAddress(addressData.getId());
        address.setAddress(addressData.getAddress());
        address.setCity(addressData.getCity());
        address.setVillage(addressData.getVillage());
        address.setSubDistrict(addressData.getSubDistrict());
        address.setZipCode(addressData.getZipCode());
        addressService.saveAddress(address);
        responseData.setStatus(true);
        responseData.setPayload(addressData);
        return ResponseEntity.ok().body(responseData);
    }

    @RequestMapping("/api/editinstituteaddress")
    public ResponseEntity<?> editInstituteAddress(@Valid @RequestBody InstituteAddressData instituteAddressData, Errors errors){
        ResponseData<InstituteAddressData> responseData = new ResponseData<>();
        if (errors.hasErrors()) {
            for (ObjectError error : errors.getAllErrors()) {
                responseData.getMessages().add(error.getDefaultMessage());
            }
            responseData.setStatus(false);
            responseData.setPayload(null);
            return ResponseEntity.badRequest().body(responseData);
        }

        Address address = addressService.findOneAddress(instituteAddressData.getId());
        address.setAddress(instituteAddressData.getAddress());
        address.setCity(instituteAddressData.getCity());
        address.setVillage(instituteAddressData.getVillage());
        address.setSubDistrict(instituteAddressData.getSubDistrict());
        address.setZipCode(instituteAddressData.getZipCode());
        addressService.saveAddress(address);

        responseData.setStatus(true);
        responseData.setPayload(instituteAddressData);
        return ResponseEntity.ok().body(responseData);
    }

    @RequestMapping("/api/editjobdesc")
    public ResponseEntity<?> editJobdesc(@Valid @RequestBody JobDescData jobDescData, Errors errors){
        ResponseData<JobDescData> responseData = new ResponseData<>();
        if (errors.hasErrors()) {
            for (ObjectError error : errors.getAllErrors()) {
                responseData.getMessages().add(error.getDefaultMessage());
            }
            responseData.setStatus(false);
            responseData.setPayload(null);
            return ResponseEntity.badRequest().body(responseData);
        }

        JobDesc jobDesc = jobDescService.findJobdesc(jobDescData.getId());
        jobDesc.setInstitutePhone(jobDescData.getInstitutePhone());
        jobDesc.setInstituteName(jobDescData.getInstituteName());
        jobDesc.setJob(jobDescData.getJob());
        jobDescService.saveJob(jobDesc);

        responseData.setStatus(true);
        responseData.setPayload(jobDescData);
        return ResponseEntity.ok().body(responseData);
    }

    @RequestMapping("/api/editmember")
    public ResponseEntity<?> editMember(@Valid @RequestBody DetailMemberData detailMemberData, Errors errors) {
        ResponseData<DetailMemberData> responseData = new ResponseData<>();
        if (errors.hasErrors()) {
            for (ObjectError error : errors.getAllErrors()) {
                responseData.getMessages().add(error.getDefaultMessage());
            }
            responseData.setStatus(false);
            responseData.setPayload(null);
            return ResponseEntity.badRequest().body(responseData);
        }

        try {
            Member member = memberService.findMember(detailMemberData.getMemberNumber());
            member.setEmail(detailMemberData.getEmail());
            member.setIdentityNumber(detailMemberData.getIdentityNumber());
            member.setDateOfBirth(new SimpleDateFormat("yyyy-MM-dd").parse(detailMemberData.getDateOfBirth()));
            member.setFullName(detailMemberData.getFullName());
            member.setGender(detailMemberData.getGender());
            member.setLastEducation(detailMemberData.getLastEducation());
            member.setPhoneNumber(detailMemberData.getPhoneNumber());
            member.setMaritalStatus(detailMemberData.getMaritalStatus());
            member.setPlaceOfBirth(detailMemberData.getPlaceOfBirth());
            member.setTelephoneNumber(detailMemberData.getTelephoneNumber());
            memberService.save(member);
        }catch (Exception e){
            responseData.getMessages().add(e.getMessage());
            responseData.setStatus(false);
            responseData.setPayload(null);
            return ResponseEntity.internalServerError().body(responseData);
        }

        responseData.setStatus(true);
        responseData.setPayload(detailMemberData);
        return ResponseEntity.ok().body(responseData);
    }
}
