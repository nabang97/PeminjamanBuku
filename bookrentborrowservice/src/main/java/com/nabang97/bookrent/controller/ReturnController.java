package com.nabang97.bookrent.controller;

import com.nabang97.bookrent.dto.ResponseData;
import com.nabang97.bookrent.dto.ReturnData;
import com.nabang97.bookrent.model.ReturnBooks;
import com.nabang97.bookrent.services.ReturnService;
import com.nabang97.bookrent.util.AbstractManageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User         : Yolanda Parawita
 * Date & Time  : 19/06/2022 & 17:47
 */

@RestController
public class ReturnController extends AbstractManageBean {

    @Autowired
    private ReturnService returnService;

    @GetMapping("/api/borrow/books/{code}")
    public ResponseEntity<?> getBorrowBooks(@PathVariable String code, @RequestHeader (name="Authorization") String token){
        Map<String, Object> map = isAuthenticated(token);
        if (String.valueOf(map.get("isAuthenticated")).equals("true")){
            return ResponseEntity.ok().body(returnService.getAllBooksByBookingCode(code));
        }

        return ResponseEntity.badRequest().body("User not authenticated");

    }

    @PostMapping("/api/returnbooks")
    public ResponseEntity<?> updateReturnBooks(@RequestHeader (name="Authorization") String token, @Valid @RequestBody ReturnData returnData, Errors errors) throws Exception {

        ResponseData<ReturnBooks> responseData = new ResponseData<>();
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
            return returnService.updateReturnBooks(returnData);
        }

        return ResponseEntity.badRequest().body("User not authenticated");

    }

}
