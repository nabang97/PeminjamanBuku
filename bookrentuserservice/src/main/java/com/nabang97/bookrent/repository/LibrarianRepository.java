package com.nabang97.bookrent.repository;

import com.nabang97.bookrent.model.Librarian;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by IntelliJ IDEA.
 * User         : Yolanda Parawita
 * Date & Time  : 18/06/2022 & 10:08
 */

public interface LibrarianRepository extends CrudRepository<Librarian, String> {

    Boolean existsByIdentityNumber(String identityNumber);
    Boolean existsByEmail(String email);
}
