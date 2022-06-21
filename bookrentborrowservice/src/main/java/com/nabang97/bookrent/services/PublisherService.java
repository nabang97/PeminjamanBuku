package com.nabang97.bookrent.services;

import com.nabang97.bookrent.model.Publisher;
import com.nabang97.bookrent.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by IntelliJ IDEA.
 * User         : Yolanda Parawita
 * Date & Time  : 20/06/2022 & 10:19
 */

@Service
public class PublisherService {
    @Autowired
    private PublisherRepository publisherRepository;

    public Publisher save(Publisher publisher){
        System.out.println("save:"+publisher);
        return publisherRepository.save(publisher);
    }

    public Publisher saveAll(List<Publisher> publisher){
        System.out.println(publisher);
        return (Publisher) publisherRepository.saveAll(publisher);
    }

    public Publisher findPublisher(Integer id){
        Optional publisher = publisherRepository.findById(id);
        if (publisher.isPresent()){
            return (Publisher) publisher.get();
        }
        return null;
    }

    public Publisher edit(Publisher publisher){
        if (findPublisher(publisher.getId()) == null){
            return null;
        }
        return publisherRepository.save(publisher);
    }

    public List<Publisher> getAllPublisher(){
        return (List<Publisher>) publisherRepository.findAll();
    }

    public List<Publisher> getPublisherByName(String name){
        System.out.println(name);
        return publisherRepository.findAllByNameLike("%"+name+"%");
    }
}
