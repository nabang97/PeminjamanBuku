package com.nabang97.bookrent.controller;

import com.nabang97.bookrent.dto.*;
import com.nabang97.bookrent.model.Bookshelf;
import com.nabang97.bookrent.model.Publisher;
import com.nabang97.bookrent.services.BookshelfService;
import com.nabang97.bookrent.util.AbstractManageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User         : Yolanda Parawita
 * Date & Time  : 20/06/2022 & 11:26
 */

@RestController
public class BookshelfController extends AbstractManageBean {

    @Autowired
    private BookshelfService bookshelfService;

    @GetMapping("/bookshelf/getall")
    public ResponseEntity<?> getAllBookshelf(@RequestHeader(name="Authorization") String token){

        Map<String, Object> map = isAuthenticated(token);
        if (String.valueOf(map.get("isAuthenticated")).equals("true")){
            try {
                return ResponseEntity.ok().body(bookshelfService.getAllBookshelf());
            }catch (Exception e){
                ResponseEntity.internalServerError().body(e);
            }

        }

        return ResponseEntity.badRequest().body("User not authenticated");
    }

    @RequestMapping("/bookshelf/searchbyname")
    public ResponseEntity<?> getBookshelfByName(@RequestHeader(name="Authorization") String token, @NotEmpty @RequestBody BookshelfSearchData bookshelfSearchData , Errors errors){

        ResponseData<Bookshelf> responseData = new ResponseData<>();

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
                return ResponseEntity.ok().body(bookshelfService.getBookshelfByName(bookshelfSearchData.getName()));
            }catch (Exception e){
                ResponseEntity.internalServerError().body(e);
            }

        }

        return ResponseEntity.badRequest().body("User not authenticated");
    }

    @RequestMapping("/bookshelf/add")
    public ResponseEntity<?> addBookshelf(@RequestHeader(name="Authorization") String token, @Valid @RequestBody BookshelfData bookshelf, Errors errors){
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
                for (String x:bookshelf.getBookshelves()) {
                    Bookshelf bookshelf1 = new Bookshelf();
                    bookshelf1.setName(x);
                    bookshelfService.save(bookshelf1);
                }
            }catch (Exception e){
                ResponseEntity.internalServerError().body(e);
            }
            return ResponseEntity.ok().body("Bookshelf added successfully");
        }

        return ResponseEntity.badRequest().body("User not authenticated");
    }

    @RequestMapping("/bookshelf/add")
    public ResponseEntity<?> editBookshelf(@RequestHeader(name="Authorization") String token, @Valid @RequestBody BookshelfEditData bookshelf, Errors errors){
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
                Bookshelf bookshelf1 = bookshelfService.findBookshelf(bookshelf.getId());
                if(bookshelf1 == null)
                    return ResponseEntity.ok().body("Bookshelf not found");

                bookshelf1.setName(bookshelf.getName());
                bookshelfService.save(bookshelf1);

            }catch (Exception e){
                ResponseEntity.internalServerError().body(e);
            }
            return ResponseEntity.ok().body("Publisher added successfully");
        }

        return ResponseEntity.badRequest().body("User not authenticated");
    }

}
