package com.nabang97.bookrent.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by IntelliJ IDEA.
 * User         : Yolanda Parawita
 * Date & Time  : 19/06/2022 & 11:10
 */

@Entity
@Data
public class Bookshelf {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
}
