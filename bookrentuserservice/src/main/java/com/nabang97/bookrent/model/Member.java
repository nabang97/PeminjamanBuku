package com.nabang97.bookrent.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User         : Yolanda Parawita
 * Date & Time  : 18/06/2022 & 8:21
 */

@Data
@Entity
public class Member {
    @Id
    private String memberNumber;
    private String identityNumber;
    private String fullName;
    private String placeOfBirth;
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;
    private String gender;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "home_address", insertable = true, updatable = true)
    private Address homeAddress;
    private String phoneNumber;
    private String telephoneNumber;
    private String lastEducation;
    @ManyToOne
    @JoinColumn(name = "job", insertable = true, updatable = true)
    private JobDesc job;
    private String maritalStatus;
    private String email;
    private Date memberSince;
}
