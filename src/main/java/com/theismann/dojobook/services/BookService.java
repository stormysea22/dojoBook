package com.theismann.dojobook.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.theismann.dojobook.models.Book;
import com.theismann.dojobook.repositories.BookRepository;

@Service
public class BookService {
    // adding the book repository as a dependency
    private final BookRepository bookRepository;
    
    //this is constructor
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    // returns all the books
    public List<Book> allBooks() {
        return bookRepository.findAll();
    }
    // creates a book
    public Book createBook(Book b) {
        return bookRepository.save(b);
    }
    // retrieves a book
    public Book findBook(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }
     // update book
	public Book updateBook(Long id, String title, String desc, String lang, Integer numOfPages) {
		Book toUpdate = this.bookRepository.findById(id).orElse(null);
		if(toUpdate == null) {
			return null;
		} else{
			toUpdate.setTitle(title);
			toUpdate.setDescription(desc);
			toUpdate.setLanguage(lang);
			toUpdate.setNumberOfPages(numOfPages);
			
		 return this.bookRepository.save(toUpdate);
		}
	}
	
	public Book updateBook(Book book) {
		return this.bookRepository.save(book);
	}
	
	public void deleteBook(Long id) {
		this.bookRepository.deleteById(id);		
	}
}
