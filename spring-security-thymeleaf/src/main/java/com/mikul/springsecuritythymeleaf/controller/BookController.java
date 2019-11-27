package com.mikul.springsecuritythymeleaf.controller;

import com.mikul.springsecuritythymeleaf.dao.BookRepository;
import com.mikul.springsecuritythymeleaf.exception.BookIdMismatchException;
import com.mikul.springsecuritythymeleaf.exception.BookNotFoundException;
import com.mikul.springsecuritythymeleaf.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping
    public Iterable findAll() {
        return bookRepository.findAll();
    }

    @GetMapping("/title/{bookTitle}")
    public List findByTitle(@PathVariable String bookTitle) {
        return bookRepository.findByTitle(bookTitle);
    }

    @GetMapping("/{id}")
    public Book findOne(@PathVariable Long id) {
        if(bookRepository.findById(id).isPresent()) {
            return bookRepository.findById(id).get();
        } else {
            throw new BookIdMismatchException("Bad id");
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Book create(@RequestBody Book book) {
        return bookRepository.save(book);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        if (bookRepository.findById(id).isPresent()) {
            bookRepository.deleteById(id);
        } else {
            throw new BookIdMismatchException("Bad id");
        }
    }

    @PutMapping("/{id}")
    public Book updateBook(@RequestBody Book book, @PathVariable Long id) {
        if (book.getId() != id) {
            throw new BookIdMismatchException("Bad id");
        }
        bookRepository.findById(id);
        return bookRepository.save(book);
    }
}
