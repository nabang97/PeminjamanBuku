package com.nabang97.bookrent.services;

import com.nabang97.bookrent.dto.ReturnData;
import com.nabang97.bookrent.model.ReturnBooks;
import com.nabang97.bookrent.repository.ReturnBooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User         : Yolanda Parawita
 * Date & Time  : 18/06/2022 & 10:20
 */

@Service
public class ReturnService {
    @Autowired
    ReturnBooksRepository returnBooksRepository;

    @Autowired
    BookService bookService;

    public List<ReturnBooks> getAllBooksByBookingCode(String code){
        return returnBooksRepository.getAllBooksByBookingCode(code);
    }

    public ResponseEntity<?> updateReturnBooks(ReturnData returnData) throws Exception {
        if (!bookService.isBookExist(returnData.getBookCode()))
            return ResponseEntity.ok().body("There's no book to returned");
        try{
            returnBooksRepository.updateReturnBooks(returnData.getBookingCode(), returnData.getBookCode());
        }
        catch (Exception e){
            throw new Exception("Failed Return Books", e);
        }
       bookService.updateBookStockPlus(returnData.getBookCode());

        return ResponseEntity.ok().body("Book has been returned");
    }
}
