package com.nabang97.bookrent.repository;

import com.nabang97.bookrent.model.Bookshelf;
import com.nabang97.bookrent.model.Publisher;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User         : Yolanda Parawita
 * Date & Time  : 19/06/2022 & 12:24
 */

public interface BookshelfRepository extends CrudRepository<Bookshelf, Integer> {
    List<Bookshelf> findAllByNameLike(String name);
}
