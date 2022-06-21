package com.nabang97.bookrent.dto;

import javax.validation.constraints.NotNull;

/**
 * Created by IntelliJ IDEA.
 * User         : Yolanda Parawita
 * Date & Time  : 20/06/2022 & 22:23
 */

public class OneRoleData {
    @NotNull(message = "id is required")
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
