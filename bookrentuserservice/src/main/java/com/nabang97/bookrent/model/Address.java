package com.nabang97.bookrent.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by IntelliJ IDEA.
 * User         : Yolanda Parawita
 * Date & Time  : 18/06/2022 & 8:27
 */

@Entity
@Data
public class Address {
    @Id
    private String id;
    private String address;
    private String village;
    private String subDistrict;
    private String city;
    private String zipCode;

}
