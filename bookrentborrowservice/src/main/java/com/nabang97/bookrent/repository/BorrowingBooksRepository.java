package com.nabang97.bookrent.repository;

import com.nabang97.bookrent.model.BorrowingBooks;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by IntelliJ IDEA.
 * User         : Yolanda Parawita
 * Date & Time  : 19/06/2022 & 15:17
 */

public interface BorrowingBooksRepository extends CrudRepository<BorrowingBooks, String> {

}
