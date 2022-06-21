package com.nabang97.bookrent.dto;

import com.nabang97.bookrent.model.Address;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * Created by IntelliJ IDEA.
 * User         : Yolanda Parawita
 * Date & Time  : 20/06/2022 & 20:56
 */

public class LibrarianData {
    @NotEmpty(message = "nip is required")
    private String nip;
    @NotEmpty(message = "identityNumber is required")
    private String identityNumber;
    @NotEmpty(message = "password is required")
    private String password;
    @NotEmpty(message = "fullName is required")
    private String fullName;
    @NotEmpty(message = "phoneNumber is required")
    private String phoneNumber;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
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

    @NotEmpty(message = "email is required")
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getIdentityNumber() {
        return identityNumber;
    }

    public void setIdentityNumber(String identityNumber) {
        this.identityNumber = identityNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

}
