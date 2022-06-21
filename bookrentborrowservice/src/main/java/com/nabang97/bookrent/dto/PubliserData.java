package com.nabang97.bookrent.dto;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User         : Yolanda Parawita
 * Date & Time  : 20/06/2022 & 10:29
 */

public class PubliserData {
    public List<String> getPublishers() {
        return publishers;
    }

    public void setPublishers(List<String> publishers) {
        this.publishers = publishers;
    }

    @NotNull(message = "publisher is required")
    private List<String> publishers;
}
