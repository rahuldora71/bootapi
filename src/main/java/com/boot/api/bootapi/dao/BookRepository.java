package com.boot.api.bootapi.dao;

import org.springframework.data.repository.CrudRepository;

import com.boot.api.bootapi.entities.Book;
import java.util.List;


public interface BookRepository extends CrudRepository<Book,Integer>{
    public Book findById(int id);

}
