package com.nabang97.bookrent.services;

import com.nabang97.bookrent.model.Bookshelf;
import com.nabang97.bookrent.model.Publisher;
import com.nabang97.bookrent.repository.BookshelfRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by IntelliJ IDEA.
 * User         : Yolanda Parawita
 * Date & Time  : 20/06/2022 & 11:26
 */

@Service
public class BookshelfService {

    @Autowired
    private BookshelfRepository bookshelfRepository;

    public Bookshelf save(Bookshelf bookshelf){
        return bookshelfRepository.save(bookshelf);
    }

    public List<Bookshelf> saveAll(List<Bookshelf> bookshelves){
        return (List<Bookshelf>) bookshelfRepository.saveAll(bookshelves);
    }

    public Bookshelf findBookshelf(int id){
        Optional bookshelf = bookshelfRepository.findById(id);
        if (bookshelf.isPresent())
            return (Bookshelf) bookshelf.get();

        return null;
    }
    public Bookshelf edit(Bookshelf bookshelf){
        if (findBookshelf(bookshelf.getId()) == null){
            return null;
        }
        return bookshelfRepository.save(bookshelf);
    }

    public List<Bookshelf> getAllBookshelf(){
        return (List<Bookshelf>) bookshelfRepository.findAll();
    }

    public List<Bookshelf> getBookshelfByName(String name){
        System.out.println(name);
        return bookshelfRepository.findAllByNameLike("%"+name+"%");
    }
}
