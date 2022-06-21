package com.nabang97.bookrent.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by IntelliJ IDEA.
 * User         : Yolanda Parawita
 * Date & Time  : 18/06/2022 & 18:08
 */
@Data
@Entity @NoArgsConstructor
@AllArgsConstructor
public class Role {
    @Id
    private String roleId;
    private String name;
}
