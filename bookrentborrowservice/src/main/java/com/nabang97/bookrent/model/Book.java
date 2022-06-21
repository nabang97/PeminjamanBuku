package com.nabang97.bookrent.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Created by IntelliJ IDEA.
 * User         : Yolanda Parawita
 * Date & Time  : 19/06/2022 & 11:06
 */
@Data
@Entity
public class Book {
    @Id
    private String code;
    private String title;
    @ManyToOne
    @JoinColumn(name = "writer", insertable = true, updatable = true)
    private Writers writer;
    @ManyToOne
    @JoinColumn(name = "publisher", insertable = true, updatable = true)
    private Publisher publisher;
    private String publishCity;
    private int pagesNumber;
    private int stock;
    @ManyToOne
    @JoinColumn(name = "book_type", insertable = true, updatable = true)
    private BookCategory bookType;
    @ManyToOne
    @JoinColumn(name = "bookshelf", insertable = true, updatable = true)
    private Bookshelf bookshelf;
    private int publishYear;
    private int publishMonth;


}
