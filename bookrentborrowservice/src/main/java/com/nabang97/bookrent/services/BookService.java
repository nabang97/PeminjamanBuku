package com.nabang97.bookrent.services;

import com.nabang97.bookrent.dto.BookData;
import com.nabang97.bookrent.dto.ResponseData;
import com.nabang97.bookrent.model.Book;
import com.nabang97.bookrent.model.BookCategory;
import com.nabang97.bookrent.model.Bookshelf;
import com.nabang97.bookrent.model.Publisher;
import com.nabang97.bookrent.repository.BookCategoryRepository;
import com.nabang97.bookrent.repository.BookRepository;
import com.nabang97.bookrent.repository.PublisherRepository;
import com.nabang97.bookrent.repository.BookshelfRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Created by IntelliJ IDEA.
 * User         : Yolanda Parawita
 * Date & Time  : 18/06/2022 & 10:19
 */

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;
    @Autowired
    BookCategoryRepository bookCategoryRepository;
    @Autowired
    PublisherRepository publisherRepository;
    @Autowired
    BookshelfRepository bookshelfRepository;

    public Book saveBook(Book book){
        return bookRepository.save(book);
    }

    public Book findOneBook(String code){
        Optional book = bookRepository.findById(code);
        if(book.isPresent()){
            return (Book) book.get();
        }
        return null;
    }

    public int getBookStock(String code){
        if (isBookExist(Arrays.asList(new String[]{code}))){
            return findOneBook(code).getStock();
        }
        return 0;
    }

    public List<Book> getBooksByTitle(String title){
        return bookRepository.findBooksByTitle("%"+title+"%");
    }

    public BookCategory findBookCategory(int id){
        Optional bookCategory = bookCategoryRepository.findById(id);
        if (bookCategory.isPresent()){
            return (BookCategory) bookCategory.get();
        }
        return null;
    }

    public Publisher findPublisher(int id){
        Optional publisher = publisherRepository.findById(id);
        if (publisher.isPresent()){
            return (Publisher) publisher.get();
        }
        return null;
    }

    public Bookshelf findBookshelf(int id){
        Optional rack = bookshelfRepository.findById(id);
        if (rack.isPresent()){
            return (Bookshelf) rack.get();
        }
        return null;
    }

    public Boolean isBookExist(List<String> code){
        return bookRepository.isBooksisExist(code);
    }

    public List<Book> getAvaibaleBooks(List<String> codes){
        return bookRepository.getAvailableBooks(codes);
    }

    public void updateBookStockMinus(List<String> code){
       bookRepository.updateStockMinus(code);
    }

    public void updateBookStockPlus(List<String> code){
        bookRepository.updateStockPlus(code);
    }

    public ResponseEntity<ResponseData<?>> addNewBook(BookData bookData){
        ResponseData<BookData> responseData = new ResponseData();

        if (isBookExist(Arrays.asList(new String[]{bookData.getCode()}))){
            responseData.setStatus(false);
            responseData.setPayload(bookData);
            responseData.getMessages().add("Book with that code is already exist!");
            return ResponseEntity.badRequest().body(responseData);
        }

        try {
            Book book = new Book();
            if (bookData.getBookType() == 0)
                book.setBookType(findBookCategory(bookData.getBookType()));

            if (bookData.getPublisher() == 0)
                book.setPublisher(findPublisher(bookData.getPublisher()));

            if (bookData.getBookshelf() == 0)
                book.setBookshelf(findBookshelf(bookData.getBookshelf()));

            book.setCode(bookData.getCode());
            book.setTitle(bookData.getTitle());
            book.setPagesNumber(bookData.getPagesNumber());
            book.setPublishCity(bookData.getPublishCity());
            book.setPublishMonth(bookData.getPublishMonth());
            book.setPublishYear(bookData.getPublishYear());
            book.setStock(bookData.getStock());
            saveBook(book);

            ResponseData<Book> responseBook = new ResponseData();
            responseBook.setStatus(true);
            responseBook.getMessages().add("Success");
            responseBook.setPayload(book);
            return ResponseEntity.badRequest().body(responseBook);
        }catch (Exception e){
            responseData.setStatus(false);
            responseData.setPayload(bookData);
            responseData.getMessages().add("Gagal menyimpan!");
            return ResponseEntity.badRequest().body(responseData);
        }

    }

    public ResponseEntity<ResponseData<?>> editBook(BookData bookData){
        ResponseData<BookData> responseData = new ResponseData();

        if (isBookExist(Arrays.asList(new String[]{bookData.getCode()}))){
            responseData.setStatus(false);
            responseData.setPayload(bookData);
            responseData.getMessages().add("Book with that code is already exist!");
            return ResponseEntity.badRequest().body(responseData);
        }

        try {
            Book book = findOneBook(bookData.getCode());
            if (bookData.getBookType() == 0)
                book.setBookType(findBookCategory(bookData.getBookType()));

            if (bookData.getPublisher() == 0)
                book.setPublisher(findPublisher(bookData.getPublisher()));

            if (bookData.getBookshelf() == 0)
                book.setBookshelf(findBookshelf(bookData.getBookshelf()));

            book.setCode(bookData.getCode());
            book.setTitle(bookData.getTitle());
            book.setPagesNumber(bookData.getPagesNumber());
            book.setPublishCity(bookData.getPublishCity());
            book.setPublishMonth(bookData.getPublishMonth());
            book.setPublishYear(bookData.getPublishYear());
            book.setStock(bookData.getStock());
            saveBook(book);

            ResponseData<Book> responseBook = new ResponseData();
            responseBook.setStatus(true);
            responseBook.getMessages().add("Success");
            responseBook.setPayload(book);
            return ResponseEntity.badRequest().body(responseBook);
        }catch (Exception e){
            responseData.setStatus(false);
            responseData.setPayload(bookData);
            responseData.getMessages().add("Gagal menyimpan!");
            return ResponseEntity.badRequest().body(responseData);
        }

    }

}
