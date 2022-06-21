package com.nabang97.bookrent.services;

import com.nabang97.bookrent.dto.ResponseData;
import com.nabang97.bookrent.model.Book;
import com.nabang97.bookrent.model.BookBorrowId;
import com.nabang97.bookrent.model.BorrowingBooks;
import com.nabang97.bookrent.model.ReturnBooks;
import com.nabang97.bookrent.repository.BorrowingBooksRepository;
import com.nabang97.bookrent.repository.ReturnBooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by IntelliJ IDEA.
 * User         : Yolanda Parawita
 * Date & Time  : 18/06/2022 & 10:19
 */

@Service
public class BorrowingService {
    @Autowired
    private BorrowingBooksRepository borrowingBooksRepository;

    @Autowired
    private ReturnBooksRepository returnBooksRepository;

    @Autowired
    private BookService bookService;


    public ReturnBooks saveReturnBook(ReturnBooks returnBooks){
        return returnBooksRepository.save(returnBooks);
    }

    public List<ReturnBooks> saveAllReturnBooks(List<ReturnBooks> list){
        return (List<ReturnBooks>) returnBooksRepository.saveAll(list);
    }

    public Boolean isStockStillExist(String bookCode){
        if(bookService.isBookExist(Arrays.asList(new String[]{"bookCode"}))&& bookService.getBookStock(bookCode)>0){
            return true;
        }
        return false;
    }


    public BorrowingBooks saveBookingBooks(BorrowingBooks borrowingBooks){
        return borrowingBooksRepository.save(borrowingBooks);
    }

    public ResponseEntity<?> borrowBookNow(List<String> books, String username){
        ResponseData<List<Book>> responseData = new ResponseData<>();
        List<Book> availableBooks = bookService.getAvaibaleBooks(books);
        System.out.println(availableBooks);
        if (availableBooks.size() > 0){
            try {
                String bookingCode = String.valueOf(new Date().getTime());
                BorrowingBooks borrowingBooks = new BorrowingBooks();
                borrowingBooks.setBookingCode(bookingCode);
                List<ReturnBooks> returnBooks = availableBooks.stream().map(x -> {
                    ReturnBooks returnBook = new ReturnBooks();
                    returnBook.setBookBorrowId(new BookBorrowId(bookingCode, x.getCode()));
                    return returnBook;
                }).collect(Collectors.toList());

                bookService.updateBookStockMinus(returnBooks.stream().map(x-> x.getBookBorrowId().getBookCode()).collect(Collectors.toList()));
                borrowingBooks.setReturnBooks(returnBooks);
                borrowingBooks.setMemberNumber(username);
                Calendar calendar = Calendar.getInstance();
                calendar.add(Calendar.WEEK_OF_MONTH, 1);
                borrowingBooks.setReturnDate(calendar.getTime());
                saveBookingBooks(borrowingBooks);
                saveAllReturnBooks(returnBooks);

                ResponseData<String> responseData1 = new ResponseData<>();
                responseData1.setPayload(bookingCode);
                responseData1.setStatus(true);
                return ResponseEntity.ok().body(responseData1);
            }catch (Exception e ){
                responseData.setStatus(false);
                responseData.setPayload(availableBooks);
                responseData.getMessages().add("Buku gagal untuk dipinjam");
                return ResponseEntity.ok().body(responseData);
            }

        }
        responseData.setStatus(false);
        responseData.setPayload(null);
        responseData.getMessages().add("Buku tidak tersedia untuk dipinjam");
        return ResponseEntity.ok().body(responseData);
    }

}
