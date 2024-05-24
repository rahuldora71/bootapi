package com.boot.api.bootapi.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.boot.api.bootapi.dao.BookRepository;
import com.boot.api.bootapi.entities.Book;
@Component
public class BookService {

    @Autowired
    private BookRepository bookRepository;


    // private  static List<Book> list=new ArrayList<>();

    // static{
    //     list.add(new Book(12,"Math","arya"));
    //     list.add(new Book(122,"Math2","arya2"));
    //     list.add(new Book(123,"Math3","arya3"));
    //     list.add(new Book(124,"Math4","arya"));
    // }


    //get all books
    public List<Book> getBooks(){
        // return list;

        List<Book> all = (List<Book>)this.bookRepository.findAll();

        return all ;

    }

    // get single Book by id
    public Book getBookById(int id){
        Book book=null;
    //    book= list.stream().filter(e->e.getId()==id).findFirst().get();
    //    return book;
            try {
                book = this.bookRepository.findById(id);

            } catch (Exception e) {
                // TODO: handle exception
                e.printStackTrace();
            }
            return book;

    }

    //Add Book
    public Book addBook(Book b){
        // list.add(b);
        // return b;

        Book save = bookRepository.save(b);
        return save;
    }

    // Add Multiple book
    public List<Book> addBook(List<Book> list ){
        // list.add(b);
        // return b;

        List<Book> saveAll =(List<Book>) bookRepository.saveAll(list);
        return saveAll;
    }

    //delet Book
    public void deleteBook(int id){
        // list.remove(list.stream().filter(e->e.getId()==id).findFirst().get());

        bookRepository.deleteById(id);


    }

    //Update the book
    public void updateBook(Book book, int id)
    {

        // Book b=new Book();
        // b =list.stream().filter(e->e.getId()==id).findFirst().get();

        // int a=list.indexOf(list.stream().filter(e->e.getId()==id).findFirst().get());
        // list.remove(list.stream().filter(e->e.getId()==id).findFirst().get());
        // list .add(a,book);

        book.setId(id);
        bookRepository.save(book);

        
    }
}
