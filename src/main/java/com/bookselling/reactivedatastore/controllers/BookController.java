package com.bookselling.reactivedatastore.controllers;

/*
 * @author santoshsindham
 * @date 15/12/17, 9:45 PM
 */

import com.bookselling.reactivedatastore.models.Book;
import com.bookselling.reactivedatastore.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping ("/api")
@CrossOrigin ("*")
public class BookController {

    @Autowired
    BookRepository bookRepository;

    @GetMapping("/books")
    public List<Book> getAllBooks(){

        Sort sortByCreatedAtDesc = new Sort(Sort.Direction.DESC, "createdAt");
        return bookRepository.findAll(sortByCreatedAtDesc);
    }

    @PostMapping("/books")
    public Book createBook(@Valid @RequestBody Book book){
        return bookRepository.save(book);
    }

    @GetMapping(value = "/books/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable("id") String id){

        Book book = bookRepository.findById(id).get();

        if(book == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else{
            return new ResponseEntity<>(book, HttpStatus.OK);
        }
    }

    @PutMapping(value = "/books/{id}")
    public ResponseEntity<Book> updateToDo(@PathVariable("id") String id, @Valid @RequestBody Book book){

        Book bookData = bookRepository.findById(id).get();

        if(bookData == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else{
            bookData.setAuthor(book.getAuthor());
            bookData.setCost(book.getCost());
            bookData.setDescription(book.getDescription());
            bookData.setImageUrl(book.getImageUrl());
            bookData.setTitle(book.getTitle());
            bookData.setUpdatedAt(new Date());

            Book updatedBook = bookRepository.save(bookData);
            return new ResponseEntity<>(updatedBook, HttpStatus.OK);
        }
    }

    @DeleteMapping(value = "/books/{id}")
    public void deleteBook(@PathVariable("id") String id){
        bookRepository.deleteById(id);
    }
}
