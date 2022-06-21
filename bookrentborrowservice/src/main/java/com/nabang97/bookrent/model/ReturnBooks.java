package com.nabang97.bookrent.model;

import lombok.Data;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.UniqueConstraint;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User         : Yolanda Parawita
 * Date & Time  : 19/06/2022 & 15:01
 */
@Entity
@Data
public class ReturnBooks {
    @EmbeddedId
    private BookBorrowId bookBorrowId;
    private Date returnDate;
    private String penaltyFine;
}
