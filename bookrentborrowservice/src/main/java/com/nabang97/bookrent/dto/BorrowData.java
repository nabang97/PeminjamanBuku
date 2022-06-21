package com.nabang97.bookrent.dto;

import com.nabang97.bookrent.model.Book;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User         : Yolanda Parawita
 * Date & Time  : 19/06/2022 & 15:48
 */

public class BorrowData {

    @NotEmpty(message = "member is required")
    private String member;
    @NotNull(message = "books is required")
    private List<String> books;

    public String getMember() {
        return member;
    }

    public void setMember(String member) {
        this.member = member;
    }

    public List<String> getBooks() {
        return books;
    }

    public void setBooks(List<String> books) {
        this.books = books;
    }
}
