package com.springboot.assignment.magicofbooks.controller;

import com.springboot.assignment.magicofbooks.entity.Book;
import com.springboot.assignment.magicofbooks.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    BookService bookService;

    public List<Book> searchBookByAuthor(String authorName) {
        return bookService.searchBookByAuthor(authorName);
    }

    public List<Book> searchBookByTitle(String title) {
        return bookService.searchBookByTitle(title);
    }

    public List<Book> searchBookByPublicationName(String publication) {
        return bookService.searchBookByPublicationName(publication);
    }

    public Book searchBookByBookId(int id) {
        return bookService.searchBookByBookId(id);
    }

    public List<Book> searchBookByPriceRange(Integer minPrice, Integer maxPrice) {
        return bookService.searchBookByPriceRange(minPrice, maxPrice);
    }

    public List<Book> sortBooksByPriceAsc() {
        return bookService.sortBooksByPriceAsc();
    }
}
