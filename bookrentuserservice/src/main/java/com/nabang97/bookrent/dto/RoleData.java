package com.nabang97.bookrent.dto;

import javax.validation.constraints.NotEmpty;

/**
 * Created by IntelliJ IDEA.
 * User         : Yolanda Parawita
 * Date & Time  : 20/06/2022 & 22:08
 */

public class RoleData {

    @NotEmpty(message = "id is required")
    private int id;
    @NotEmpty(message = "name is required")
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
