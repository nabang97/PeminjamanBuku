package com.nabang97.bookrent.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User         : Yolanda Parawita
 * Date & Time  : 19/06/2022 & 18:26
 */

public class ReturnData {
    @NotEmpty(message = "bookingCode is required")
    private String bookingCode;
    @NotNull(message = "bookCode is required")
    private List<String> bookCode;

    public String getBookingCode() {
        return bookingCode;
    }

    public void setBookingCode(String bookingCode) {
        this.bookingCode = bookingCode;
    }

    public List<String> getBookCode() {
        return bookCode;
    }

    public void setBookCode(List<String> bookCode) {
        this.bookCode = bookCode;
    }
}
