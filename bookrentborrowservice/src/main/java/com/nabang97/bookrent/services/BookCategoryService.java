package com.nabang97.bookrent.services;

import com.nabang97.bookrent.dto.BookCategoryData;
import com.nabang97.bookrent.model.BookCategory;
import com.nabang97.bookrent.model.Publisher;
import com.nabang97.bookrent.repository.BookCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by IntelliJ IDEA.
 * User         : Yolanda Parawita
 * Date & Time  : 20/06/2022 & 11:41
 */
@Service
public class BookCategoryService {

    @Autowired
    BookCategoryRepository bookCategoryRepository;

    public BookCategory save(BookCategory bookCategory){
        return bookCategoryRepository.save(bookCategory);
    }
    public List<BookCategory> saveAll(List<BookCategory> bookCategories){
        return (List<BookCategory>) bookCategoryRepository.saveAll(bookCategories);
    }
    public BookCategory findCategory(Integer id){
        Optional bookCategory = bookCategoryRepository.findById(id);
        if (bookCategory.isPresent()){
            return (BookCategory) bookCategory.get();
        }
        return null;
    }

    public BookCategory edit(BookCategory bookCategory){
        if (findCategory(bookCategory.getId()) == null){
            return null;
        }
        return bookCategoryRepository.save(bookCategory);
    }

    public List<BookCategory> getAllPublisher(){
        return (List<BookCategory>) bookCategoryRepository.findAll();
    }

    public List<BookCategory> getPublisherByName(String name){
        System.out.println(name);
        return bookCategoryRepository.findAllByNameLike("%"+name+"%");
    }

}
