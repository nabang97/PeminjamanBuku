package com.nabang97.bookrent.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User         : Yolanda Parawita
 * Date & Time  : 19/06/2022 & 14:35
 */
@Entity @Data
public class BorrowingBooks {
    @Id
    private String bookingCode;
    @Temporal(TemporalType.DATE)
    private Date returnDate;
    private String memberNumber;
    @OneToMany(cascade = CascadeType.ALL)
    private List<ReturnBooks> returnBooks;
}
