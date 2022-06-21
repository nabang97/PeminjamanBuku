package com.nabang97.bookrent.repository;

import com.nabang97.bookrent.model.BookCategory;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User         : Yolanda Parawita
 * Date & Time  : 19/06/2022 & 12:13
 */

public interface BookCategoryRepository extends CrudRepository<BookCategory, Integer> {
    List<BookCategory> findAllByNameLike(String name);
}
