package com.nabang97.bookrent.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * Created by IntelliJ IDEA.
 * User         : Yolanda Parawita
 * Date & Time  : 19/06/2022 & 11:52
 */

public class BookData {
    @NotEmpty(message = "title is required")
    private String title;
    @NotEmpty(message = "code is required")
    private String code;
    @NotNull(message = "writer is required")
    private int writer;
    @NotNull(message = "publisher is required")
    private int publisher;
    @NotEmpty(message = "publishCity is required")
    private String publishCity;
    private int pagesNumber;
    @NotNull(message = "stock is required")
    private int stock;
    @NotNull(message = "bookType is required")
    private int bookType;
    private int bookshelf;
    @NotNull(message = "publishYear is required")
    private int publishYear;
    private int publishMonth;

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

    public int getBookshelf() {
        return bookshelf;
    }

    public void setBookshelf(int bookshelf) {
        this.bookshelf = bookshelf;
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
