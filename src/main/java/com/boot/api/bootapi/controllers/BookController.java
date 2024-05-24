package com.boot.api.bootapi.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.boot.api.bootapi.entities.Book;
import com.boot.api.bootapi.services.BookService;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
public class BookController {
    @Autowired
    private BookService bookService;

    // get all book handler
    // @RequestMapping(value = "/book", method = RequestMethod.GET)
    @GetMapping("/book")
    public ResponseEntity<List<Book>> getBook() {
        // Book book=new Book();
        // book.setId(23432);
        // book.setAuthor("xyz");
        // book.setTitle("Java Complete Reference");

        List<Book> list=this.bookService.getBooks();
        if (list.size()<=0) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(list);
    }

    // get single book handler
    @GetMapping("/book/{id}")
    public ResponseEntity<Book> getBook(@PathVariable("id") int id) {

        Book book=bookService.getBookById(id);

        if (book==null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(book));
    }

    // // Set single book handler
    // @PostMapping("/book")
    // public Book addBook(@RequestBody Book book) {
    //     Book b = this.bookService.addBook(book);
    //     return b;
    // }
    
    //Set Multiple book
    @PostMapping("/book")
    public List<Book> addAllBook(@RequestBody List<Book> list) {
        List<Book> book = this.bookService.addBook(list);
        return book;
    }

    // Delet book handler
    @DeleteMapping("/book/{id}")
    public List<Book> deleteBook(@PathVariable("id") int id ){
        this.bookService.deleteBook(id);
        return this.bookService.getBooks();

    }

    //Update Book Handler
    @PutMapping("/book/{id}")
    public void updateBook(@RequestBody Book book, @PathVariable("id") int id ) {
        this.bookService.updateBook(book,id);
        
    }

}
