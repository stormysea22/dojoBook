package com.theismann.dojobook.controllers;

import java.util.List;

//import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.theismann.dojobook.models.Book;
import com.theismann.dojobook.services.BookService;

@RestController
public class BooksControllerApi {
    private final BookService bookService;
    public BooksControllerApi(BookService bookService){
        this.bookService = bookService;
    }
    @RequestMapping("/api/books")
    public List<Book> index() {
        return ((BookService) bookService).allBooks();
    }
    
    @RequestMapping(value="/api/books", method=RequestMethod.POST)
    public Book create(@RequestParam(value="title") String title, @RequestParam(value="description") String desc, @RequestParam(value="language") String lang, @RequestParam(value="pages") Integer numOfPages) {
        Book book = new Book(title, desc, lang, numOfPages);
        return bookService.createBook(book);
    }
    
    @RequestMapping("/api/books/{id}")
    public Book show(@PathVariable("id") Long id) {
        Book book = ((BookService) bookService).findBook(id);
        return book;
    }
    
    @RequestMapping(value="/api/books/{id}/update", method=RequestMethod.PUT)
    public Book edit(@PathVariable("id") Long id, @RequestParam(value="title") String title, @RequestParam(value="description") String desc, @RequestParam(value="language") String lang, @RequestParam(value="pages") Integer numOfPages) {
    	return this.bookService.updateBook(id, title, desc, lang, numOfPages);
    }
    
    @RequestMapping(value="/api/books/{id}/delete", method=RequestMethod.DELETE)
    public void delete(@PathVariable("id") Long id) {
    	this.bookService.deleteBook(id);
    }
    	
}
