package com.nabang97.bookrent.repository;

import com.nabang97.bookrent.model.ReturnBooks;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.lang.annotation.Native;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User         : Yolanda Parawita
 * Date & Time  : 19/06/2022 & 15:19
 */

public interface ReturnBooksRepository extends CrudRepository<ReturnBooks, Object> {

    @Query(nativeQuery = true,
    value = "Select * from return_books where booking_code in (:code)")
    List<ReturnBooks> getAllBooksByBookingCode(@Param("code") String code);

    @Transactional
    @Modifying
    @Query(nativeQuery = true,
            value = "update return_books rb " +
                    "set rb.penalty_fine = (" +
                    "select case " +
                    "when bb.return_date < current_date() then ABS(datediff(bb.return_date, CURRENT_TIMESTAMP())*1000) " +
                    "else 0 end penalty " +
                    "from booking_books bb where bb.booking_code = rb.booking_code), \n" +
                    "rb.return_date = CURRENT_TIMESTAMP() " +
                    "where rb.booking_code = :code and rb.book_code in (:books)")
    void updateReturnBooks(@Param("code") String code, @Param("books") List<String> books);
}
