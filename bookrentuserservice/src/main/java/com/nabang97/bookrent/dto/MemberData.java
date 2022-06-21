package com.nabang97.bookrent.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User         : Yolanda Parawita
 * Date & Time  : 18/06/2022 & 11:45
 */

public class MemberData {
    @NotEmpty(message = "identityNumber is required")
    private String identityNumber;
    @NotEmpty(message = "password is required")
    private String password;
    @NotEmpty(message = "fullName is required")
    private String fullName;
    @NotEmpty(message = "placeOfBirth is required")
    private String placeOfBirth;
    @NotEmpty(message = "dateOfBirth is required")
    private String dateOfBirth;
    @NotEmpty(message = "gender is required")
    private String gender;
    @NotEmpty(message = "phoneNumber is required")
    private String phoneNumber;
    private String telephoneNumber;
    @NotEmpty(message = "lastEducation is required")
    private String lastEducation;
    @NotEmpty(message = "maritalStatus is required")
    private String maritalStatus;
    @NotEmpty(message = "email is required")
    private String email;

    @NotEmpty(message = "addressHome is required")
    private String addressHome;
    @NotEmpty(message = "villageHome is required")
    private String villageHome;
    @NotEmpty(message = "subDistrictHome is required")
    private String subDistrictHome;
    @NotEmpty(message = "cityHome is required")
    private String cityHome;
    @NotEmpty(message = "zipCodeHome is required")
    private String zipCodeHome;

    @NotEmpty(message = "role is required")
    private String role;

    private String addressInst;
    private String villageInst;
    private String subDistrictInst;
    private String cityInst;
    private String zipCodeInst;
    private String institutePhone;
    private String instituteName;
    private String job;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getInstitutePhone() {
        return institutePhone;
    }

    public void setInstitutePhone(String institutePhone) {
        this.institutePhone = institutePhone;
    }

    public String getInstituteName() {
        return instituteName;
    }

    public void setInstituteName(String instituteName) {
        this.instituteName = instituteName;
    }



    public String getIdentityNumber() {
        return identityNumber;
    }

    public void setIdentityNumber(String identityNumber) {
        this.identityNumber = identityNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    public void setPlaceOfBirth(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }



    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getLastEducation() {
        return lastEducation;
    }

    public void setLastEducation(String lastEducation) {
        this.lastEducation = lastEducation;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddressHome() {
        return addressHome;
    }

    public void setAddressHome(String addressHome) {
        this.addressHome = addressHome;
    }

    public String getVillageHome() {
        return villageHome;
    }

    public void setVillageHome(String villageHome) {
        this.villageHome = villageHome;
    }

    public String getSubDistrictHome() {
        return subDistrictHome;
    }

    public void setSubDistrictHome(String subDistrictHome) {
        this.subDistrictHome = subDistrictHome;
    }

    public String getCityHome() {
        return cityHome;
    }

    public void setCityHome(String cityHome) {
        this.cityHome = cityHome;
    }

    public String getZipCodeHome() {
        return zipCodeHome;
    }

    public void setZipCodeHome(String zipCodeHome) {
        this.zipCodeHome = zipCodeHome;
    }

    public String getAddressInst() {
        return addressInst;
    }

    public void setAddressInst(String addressInst) {
        this.addressInst = addressInst;
    }

    public String getVillageInst() {
        return villageInst;
    }

    public void setVillageInst(String villageInst) {
        this.villageInst = villageInst;
    }

    public String getSubDistrictInst() {
        return subDistrictInst;
    }

    public void setSubDistrictInst(String subDistrictInst) {
        this.subDistrictInst = subDistrictInst;
    }

    public String getCityInst() {
        return cityInst;
    }

    public void setCityInst(String cityInst) {
        this.cityInst = cityInst;
    }

    public String getZipCodeInst() {
        return zipCodeInst;
    }

    public void setZipCodeInst(String zipCodeInst) {
        this.zipCodeInst = zipCodeInst;
    }


}
