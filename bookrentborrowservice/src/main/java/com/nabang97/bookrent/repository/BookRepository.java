package com.nabang97.bookrent.repository;

import com.nabang97.bookrent.model.Book;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User         : Yolanda Parawita
 * Date & Time  : 19/06/2022 & 11:43
 */

public interface BookRepository extends CrudRepository<Book, String> {

    @Query(nativeQuery = true,
    value = "SELECT * FROM book b where b.title like :titleSearch")
    List<Book> findBooksByTitle(@Param("titleSearch") String name);

    @Query(nativeQuery = true,
            value = "SELECT * FROM book b where b.code in (:codes) and b.stock > 0")
    List<Book> getAvailableBooks(@Param("codes") List<String> codes);

    @Transactional
    @Modifying
    @Query(nativeQuery = true,
    value = "update book b set b.stock = (b.stock-1) where b.code in (:code)")
    void updateStockMinus(@Param("code") List<String> code);

    @Transactional
    @Modifying
    @Query(nativeQuery = true,
            value = "update book b set b.stock = (b.stock+1) where b.code in (:code)  ")
    void updateStockPlus(@Param("code") List<String> code);

    @Query(nativeQuery = true,
            value = "select case when COUNT(*) > 0 then 'true' else 'false' end is_xist from book b where b.code in (:code)  ")
    Boolean isBooksisExist(@Param("code") List<String> code);

}
