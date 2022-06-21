package com.nabang97.bookrent.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by IntelliJ IDEA.
 * User         : Yolanda Parawita
 * Date & Time  : 19/06/2022 & 11:30
 */

@Data @Entity
public class Writers {
    @Id
    private String id;
    private String name;
}
