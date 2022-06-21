package com.nabang97.bookrent.model;

import lombok.Data;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * User         : Yolanda Parawita
 * Date & Time  : 19/06/2022 & 15:13
 */

@Embeddable
@Data
public class BookBorrowId implements Serializable {
    private String bookingCode;
    private String bookCode;

    public BookBorrowId(String bookingCode, String bookCode) {
        this.bookingCode = bookingCode;
        this.bookCode = bookCode;
    }

    public BookBorrowId() {

    }
}
