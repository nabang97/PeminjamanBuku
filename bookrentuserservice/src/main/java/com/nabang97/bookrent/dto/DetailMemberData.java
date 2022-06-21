package com.nabang97.bookrent.dto;

import javax.validation.constraints.NotEmpty;

/**
 * Created by IntelliJ IDEA.
 * User         : Yolanda Parawita
 * Date & Time  : 20/06/2022 & 21:35
 */

public class DetailMemberData {
    @NotEmpty(message = "memberNumber is required")
    private String memberNumber;
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

    public String getMemberNumber() {
        return memberNumber;
    }

    public void setMemberNumber(String memberNumber) {
        this.memberNumber = memberNumber;
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

    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    public void setPlaceOfBirth(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
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
}
