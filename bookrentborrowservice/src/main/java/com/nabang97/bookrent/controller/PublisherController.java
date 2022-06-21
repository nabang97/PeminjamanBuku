package com.nabang97.bookrent.controller;
import com.nabang97.bookrent.dto.PubliserData;
import com.nabang97.bookrent.dto.PublisherSearchData;
import com.nabang97.bookrent.dto.ResponseData;
import com.nabang97.bookrent.model.Publisher;
import com.nabang97.bookrent.services.PublisherService;
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
 * Date & Time  : 20/06/2022 & 10:26
 */

@RestController
public class PublisherController extends AbstractManageBean {

    @Autowired
    PublisherService publisherService;

    @GetMapping ("/publisher/getall")
    public ResponseEntity<?> getAllPublisher(@RequestHeader(name="Authorization") String token){

        Map<String, Object> map = isAuthenticated(token);
        if (String.valueOf(map.get("isAuthenticated")).equals("true")){
            try {
                return ResponseEntity.ok().body(publisherService.getAllPublisher());
            }catch (Exception e){
                ResponseEntity.internalServerError().body(e);
            }

        }

        return ResponseEntity.badRequest().body("User not authenticated");
    }

    @RequestMapping ("/publisher/searchbyname")
    public ResponseEntity<?> getPublisherByName(@RequestHeader(name="Authorization") String token, @NotEmpty @RequestBody PublisherSearchData publisherSearchData , Errors errors){

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
                return ResponseEntity.ok().body(publisherService.getPublisherByName(publisherSearchData.getName()));
            }catch (Exception e){
                ResponseEntity.internalServerError().body(e);
            }

        }

        return ResponseEntity.badRequest().body("User not authenticated");
    }

    @RequestMapping("/publisher/add")
    public ResponseEntity<?> addPublisher(@RequestHeader(name="Authorization") String token, @Valid @RequestBody PubliserData publishers, Errors errors){
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
                for (String x:publishers.getPublishers()) {
                    Publisher publisher = new Publisher();
                    publisher.setName(x);
                    publisherService.save(publisher);
                }
            }catch (Exception e){
                ResponseEntity.internalServerError().body(e);
            }
            return ResponseEntity.ok().body("Publisher added successfully");
        }

        return ResponseEntity.badRequest().body("User not authenticated");
    }

    @RequestMapping("/publisher/edit")
    public ResponseEntity<?> editPublisher(@RequestHeader(name="Authorization") String token, @Valid @RequestBody Publisher publisher, Errors errors){
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
                if(publisherService.edit(publisher) == null)
                    return ResponseEntity.ok().body("Publisher id not found");
            }catch (Exception e){
                ResponseEntity.internalServerError().body(e);
            }
            return ResponseEntity.ok().body("Publisher added successfully");
        }

        return ResponseEntity.badRequest().body("User not authenticated");
    }

}
