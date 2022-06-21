package com.nabang97.bookrent.repository;

import com.nabang97.bookrent.model.Member;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

/**
 * Created by IntelliJ IDEA.
 * User         : Yolanda Parawita
 * Date & Time  : 18/06/2022 & 10:08
 */

public interface MemberRepository extends CrudRepository<Member, String> {
    Boolean existsByIdentityNumber(String identityNumber);

    @Query(nativeQuery = true,
           value = "Select * from member m " +
                   "where date_format(m.member_since, '%y%m%d') = date_format(current_date() , '%y%m%d') " +
                   "order by m.member_since desc limit 1")
    Optional<Member> findLastMemberToday();

    Boolean existsByEmail(String email);
}
