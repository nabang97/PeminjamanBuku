package com.nabang97.bookrent.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * Created by IntelliJ IDEA.
 * User         : Yolanda Parawita
 * Date & Time  : 19/06/2022 & 11:52
 */

public class BookEditData {
    private String title;
    @NotEmpty(message = "code is required")
    private String code;
    private int writer;
    private int publisher;
    private String publishCity;
    private int pagesNumber;
    private int stock;
    private int bookType;
    private int bookshelf;
    private int publishYear;
    private int publishMonth;

    public int getBookshelf() {
        return bookshelf;
    }

    public void setBookshelf(int bookshelf) {
        this.bookshelf = bookshelf;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getWriter() {
        return writer;
    }

    public void setWriter(int writer) {
        this.writer = writer;
    }

    public int getPublisher() {
        return publisher;
    }

    public void setPublisher(int publisher) {
        this.publisher = publisher;
    }

    public String getPublishCity() {
        return publishCity;
    }

    public void setPublishCity(String publish_city) {
        this.publishCity = publish_city;
    }

    public int getPagesNumber() {
        return pagesNumber;
    }

    public void setPagesNumber(int pagesNumber) {
        this.pagesNumber = pagesNumber;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getBookType() {
        return bookType;
    }

    public void setBookType(int bookType) {
        this.bookType = bookType;
    }


    public int getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(int publishYear) {
        this.publishYear = publishYear;
    }

    public int getPublishMonth() {
        return publishMonth;
    }

    public void setPublishMonth(int publishMonth) {
        this.publishMonth = publishMonth;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
