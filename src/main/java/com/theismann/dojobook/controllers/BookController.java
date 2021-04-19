package com.theismann.dojobook.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.theismann.dojobook.models.Book;
import com.theismann.dojobook.services.BookService;

@Controller
public class BookController {
	
	private final BookService bookService;
	
	public BookController(BookService service) {
		this.bookService = service;
	}
	
	@RequestMapping("/books")
	public String home(Model viewModel) {
		viewModel.addAttribute("allBooks", this.bookService.allBooks());
		return "home.jsp";
	}
	
	@RequestMapping("/books/new")
	public String newBook(@ModelAttribute("book") Book book) {
		return "new.jsp";
	}
	
	@RequestMapping(value="/books/create", method=RequestMethod.POST)
    public String create(@Valid @ModelAttribute("book") Book book, BindingResult result) {
        if (result.hasErrors()) {
            return "new.jsp";
        } else {
            bookService.createBook(book);
            return "redirect:/books";
        }
	}
        
    @RequestMapping("/books/{id}")
        public String showOne(@PathVariable("id")Long id, Model viewModel) {
    		Book showBook = this.bookService.findBook(id);
    		viewModel.addAttribute("showBook", showBook);
    		return "show.jsp";
    }
    
    @RequestMapping("/books/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model) {
        Book book = bookService.findBook(id);
        model.addAttribute("book", book);
        return "edit.jsp";
    }
    
    @RequestMapping(value="/books/{id}/update", method=RequestMethod.POST)
    public String update(@Valid @ModelAttribute("book") Book book, BindingResult result) {
        if (result.hasErrors()) {
            return "edit.jsp";
        } else {
        	this.bookService.updateBook(book);
            return "redirect:/books";
        }
    }
    
    @RequestMapping(value="/books/{id}/delete")
    public String destroy(@PathVariable("id") Long id) {
        bookService.deleteBook(id);
        return "redirect:/books";
    }
	
}
