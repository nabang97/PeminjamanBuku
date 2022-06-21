package com.nabang97.bookrent.dto;

import javax.validation.constraints.NotEmpty;

/**
 * Created by IntelliJ IDEA.
 * User         : Yolanda Parawita
 * Date & Time  : 20/06/2022 & 11:22
 */

public class PublisherSearchData {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NotEmpty
    private String name;
}
