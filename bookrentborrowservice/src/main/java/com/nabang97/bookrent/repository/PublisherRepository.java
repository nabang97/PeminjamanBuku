package com.nabang97.bookrent.repository;

import com.nabang97.bookrent.model.Publisher;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User         : Yolanda Parawita
 * Date & Time  : 19/06/2022 & 12:19
 */

public interface PublisherRepository extends CrudRepository<Publisher, Integer> {
    List<Publisher> findAllByNameLike(String name);
}
