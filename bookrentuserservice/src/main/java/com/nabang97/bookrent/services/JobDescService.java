package com.nabang97.bookrent.services;

import com.nabang97.bookrent.model.JobDesc;
import com.nabang97.bookrent.model.Member;
import com.nabang97.bookrent.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by IntelliJ IDEA.
 * User         : Yolanda Parawita
 * Date & Time  : 20/06/2022 & 20:46
 */

@Service
public class JobDescService {

    @Autowired
    private JobRepository jobRepository;

    public JobDesc saveJob(JobDesc jobDesc){
        return jobRepository.save(jobDesc);
    }

    public JobDesc findJobdesc(String id){
        return jobRepository.findById(id).get();
    }

}
