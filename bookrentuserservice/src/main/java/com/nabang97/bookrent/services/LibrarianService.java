package com.nabang97.bookrent.services;

import com.nabang97.bookrent.model.Librarian;
import com.nabang97.bookrent.repository.LibrarianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by IntelliJ IDEA.
 * User         : Yolanda Parawita
 * Date & Time  : 20/06/2022 & 20:47
 */

@Service
public class LibrarianService {

    @Autowired
    private LibrarianRepository librarianRepository;

    public Librarian save(Librarian librarian){
        return librarianRepository.save(librarian);
    }

    public Boolean isEmailExist(String email) {
        return librarianRepository.existsByEmail(email);
    }


    public Boolean isIdentityExist(String id){
        return librarianRepository.existsByIdentityNumber(id);
    }
}
