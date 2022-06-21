package com.nabang97.bookrent.model;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by IntelliJ IDEA.
 * User         : Yolanda Parawita
 * Date & Time  : 18/06/2022 & 8:30
 */

@Data
@Entity
public class JobDesc {
    @Id
    private String id;
    private String instituteName;
    private String institutePhone;
    private String job;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address", insertable = true, updatable = true)
    private Address address;
}
