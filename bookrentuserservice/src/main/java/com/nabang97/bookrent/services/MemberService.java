package com.nabang97.bookrent.services;

import com.nabang97.bookrent.model.Member;
import com.nabang97.bookrent.repository.MemberRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

/**
 * Created by IntelliJ IDEA.
 * User         : Yolanda Parawita
 * Date & Time  : 20/06/2022 & 20:46
 */

@Service
public class MemberService {


    @Autowired
    private MemberRepository memberRepository;

    public Boolean isEmailExist(String email) {
        return memberRepository.existsByEmail(email);
    }

    public Member save(Member member){
        return memberRepository.save(member);
    }

    public Boolean isIdentityExist(String id){
        return memberRepository.existsByIdentityNumber(id);
    }

    public Member findLastMember(){
        Optional<Member> member = memberRepository.findLastMemberToday();
        if (!member.isPresent()){
            return null;
        }
        return member.get();
    }

    public String getMemberNumber(){
        Member member = findLastMember();
        String dateRegis = new SimpleDateFormat("yyyyMMdd").format(new Date());
        int countNumber = 1;
        if (member != null) {
            String lastNumber = member.getMemberNumber().substring(8, member.getMemberNumber().length()-1);
            countNumber = Integer.parseInt(lastNumber);
            return dateRegis+ StringUtils.leftPad(String.valueOf(countNumber++), 5,"0");
        }

        return dateRegis+StringUtils.leftPad(String.valueOf(countNumber), 5, "0");
    }


    public Member findMember(String username){
        return memberRepository.findById(username).get();
    }

}
