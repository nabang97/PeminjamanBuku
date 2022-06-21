package com.nabang97.bookrent.controller;

import com.nabang97.bookrent.dto.*;
import com.nabang97.bookrent.model.Book;
import com.nabang97.bookrent.model.BookCategory;
import com.nabang97.bookrent.model.Publisher;
import com.nabang97.bookrent.services.BookCategoryService;
import com.nabang97.bookrent.services.BookService;
import com.nabang97.bookrent.util.AbstractManageBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User         : Yolanda Parawita
 * Date & Time  : 19/06/2022 & 11:50
 */

@RestController @Slf4j
public class BookController extends AbstractManageBean {

    @Autowired
    private BookService bookService;
    @Autowired
    private BookCategoryService bookCategoryService;

    @RequestMapping("/getbooks")
    public ResponseEntity<?> getBooks(@RequestHeader(name="Authorization") String token, @Valid @RequestBody BookSearchData bookData, Errors errors){
        ResponseData<BookData> responseData = new ResponseData<>();

        if (errors.hasErrors()) {
            for (ObjectError error : errors.getAllErrors()) {
                responseData.getMessages().add(error.getDefaultMessage());
            }
            responseData.setStatus(false);
            responseData.setPayload(null);
            return ResponseEntity.badRequest().body(responseData);
        }

        Map<String, Object> map = isAuthenticated(token);
        if (String.valueOf(map.get("isAuthenticated")).equals("true")){
            List<Book> books = bookService.getBooksByTitle(bookData.getTitle());
            return ResponseEntity.ok().body(books);
        }

        return ResponseEntity.badRequest().body("User not authenticated");

    }

    @RequestMapping("/book/add")
    public ResponseEntity<?> addBook(@RequestHeader(name="Authorization") String token, @Valid @RequestBody BookData bookData, Errors errors){
        ResponseData<BookData> responseData = new ResponseData<>();

        if (errors.hasErrors()) {
            for (ObjectError error : errors.getAllErrors()) {
                responseData.getMessages().add(error.getDefaultMessage());
            }
            responseData.setStatus(false);
            responseData.setPayload(null);
            return ResponseEntity.badRequest().body(responseData);
        }
        Map<String, Object> map = isAuthenticated(token);
        if (String.valueOf(map.get("isAuthenticated")).equals("true")){
            return bookService.addNewBook(bookData);
        }

        return ResponseEntity.badRequest().body("User not authenticated");
    }

    @RequestMapping("/book/add")
    public ResponseEntity<?> editBook(@RequestHeader(name="Authorization") String token, @Valid @RequestBody BookData bookData, Errors errors){
        ResponseData<BookData> responseData = new ResponseData<>();

        if (errors.hasErrors()) {
            for (ObjectError error : errors.getAllErrors()) {
                responseData.getMessages().add(error.getDefaultMessage());
            }
            responseData.setStatus(false);
            responseData.setPayload(null);
            return ResponseEntity.badRequest().body(responseData);
        }
        Map<String, Object> map = isAuthenticated(token);
        if (String.valueOf(map.get("isAuthenticated")).equals("true")){
            return bookService.editBook(bookData);
        }

        return ResponseEntity.badRequest().body("User not authenticated");
    }

    @RequestMapping("/category/add")
    public ResponseEntity<?> addBookCategory(@RequestHeader(name="Authorization") String token, @Valid @RequestBody BookCategoryData categories, Errors errors){
        ResponseData<BookData> responseData = new ResponseData<>();

        if (errors.hasErrors()) {
            for (ObjectError error : errors.getAllErrors()) {
                responseData.getMessages().add(error.getDefaultMessage());
            }
            responseData.setStatus(false);
            responseData.setPayload(null);
            return ResponseEntity.badRequest().body(responseData);
        }
        Map<String, Object> map = isAuthenticated(token);
        if (String.valueOf(map.get("isAuthenticated")).equals("true")){
            try {
                categories.getCategories().forEach(x -> {
                    BookCategory bookCategory = new BookCategory();
                    bookCategory.setName(x);
                    bookCategoryService.save(bookCategory);
                });
                return ResponseEntity.badRequest().body("Success add book category");
            }catch (Exception e){
                e.printStackTrace();
                return ResponseEntity.internalServerError().body(e.getMessage());
            }

        }

        return ResponseEntity.badRequest().body("User not authenticated");
    }

    @RequestMapping("/category/edit")
    public ResponseEntity<?> editBookCategory(@RequestHeader(name="Authorization") String token, @Valid @RequestBody BookCategory bookCategory, Errors errors){
        ResponseData<Publisher> responseData = new ResponseData<>();

        if (errors.hasErrors()) {
            for (ObjectError error : errors.getAllErrors()) {
                responseData.getMessages().add(error.getDefaultMessage());
            }
            responseData.setStatus(false);
            responseData.setPayload(null);
            return ResponseEntity.badRequest().body(responseData);
        }
        Map<String, Object> map = isAuthenticated(token);
        if (String.valueOf(map.get("isAuthenticated")).equals("true")){
            try {
                if(bookCategoryService.edit(bookCategory) == null)
                    return ResponseEntity.ok().body("Category id not found");
            }catch (Exception e){
                ResponseEntity.internalServerError().body(e);
            }
            return ResponseEntity.ok().body("Category added successfully");
        }

        return ResponseEntity.badRequest().body("User not authenticated");
    }



}
