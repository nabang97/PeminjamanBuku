package com.nabang97.bookrent.dto;

import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

/**
 * Created by IntelliJ IDEA.
 * User         : Yolanda Parawita
 * Date & Time  : 20/06/2022 & 21:12
 */

public class AddressData {
    @NotEmpty(message = "id is required")
    private String id;
    @NotEmpty(message = "address is required")
    private String address;
    @NotEmpty(message = "village is required")
    private String village;
    @NotEmpty(message = "subDistrict is required")
    private String subDistrict;
    @NotEmpty(message = "city is required")
    private String city;
    @NotEmpty(message = "zipCode is required")
    private String zipCode;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getVillage() {
        return village;
    }

    public void setVillage(String village) {
        this.village = village;
    }

    public String getSubDistrict() {
        return subDistrict;
    }

    public void setSubDistrict(String subDistrict) {
        this.subDistrict = subDistrict;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
}
