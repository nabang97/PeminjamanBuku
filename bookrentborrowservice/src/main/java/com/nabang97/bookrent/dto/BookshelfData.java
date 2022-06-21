package com.nabang97.bookrent.dto;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User         : Yolanda Parawita
 * Date & Time  : 20/06/2022 & 10:29
 */

public class BookshelfData {
    @NotNull(message = "bookshelves is required")
    private List<String> bookshelves;

    public List<String> getBookshelves() {
        return bookshelves;
    }

    public void setBookshelves(List<String> bookshelves) {
        this.bookshelves = bookshelves;
    }
}
