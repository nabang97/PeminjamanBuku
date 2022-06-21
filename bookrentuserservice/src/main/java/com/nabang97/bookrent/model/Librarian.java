package com.nabang97.bookrent.model;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * Created by IntelliJ IDEA.
 * User         : Yolanda Parawita
 * Date & Time  : 18/06/2022 & 9:48
 */

@Data
@Entity
public class Librarian {
    @Id
    private String nip;
    private String identityNumber;
    private String fullName;
    private String position;
    private String phoneNumber;
    @OneToOne(cascade = CascadeType.ALL)
    private Address address;
    private String email;


}
