package com.nabang97.bookrent.controller;

import com.nabang97.bookrent.dto.BorrowData;
import com.nabang97.bookrent.dto.ResponseData;
import com.nabang97.bookrent.model.Book;
import com.nabang97.bookrent.services.BorrowingService;
import com.nabang97.bookrent.util.AbstractManageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User         : Yolanda Parawita
 * Date & Time  : 19/06/2022 & 15:47
 */
@RestController
public class BorrowingController extends AbstractManageBean {

    @Autowired
    private BorrowingService borrowingService;


    @RequestMapping("/api/borrownow")
    public ResponseEntity<?> borrowBook(@RequestHeader (name="Authorization") String token, @RequestBody BorrowData borrowData, Errors errors){
        ResponseData<List<Book>> responseData = new ResponseData<>();

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
            return borrowingService.borrowBookNow(borrowData.getBooks(), borrowData.getMember());
        }

        return ResponseEntity.badRequest().body("User not authenticated");
    }


}
