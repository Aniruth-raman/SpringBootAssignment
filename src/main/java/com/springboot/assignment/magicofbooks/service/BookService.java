package com.springboot.assignment.magicofbooks.service;

import com.springboot.assignment.magicofbooks.dao.BookRepository;
import com.springboot.assignment.magicofbooks.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book getBook(int id) {
        return (Book) bookRepository.findById(id).get();
    }

    public List<Book> searchBookByAuthor(String authorName) {
        return bookRepository.findByAuthorNameContainingIgnoreCase(authorName);
    }

    public List<Book> searchBookByTitle(String title) {
        return bookRepository.findByTitleContainingIgnoreCase(title);
    }

    public List<Book> searchBookByPublicationName(String publication) {
        return bookRepository.findByPublicationContainingIgnoreCase(publication);
    }

    public Book searchBookByBookId(int id) {
        return bookRepository.findById(id).get();
    }

    public List<Book> searchBookByPriceRange(Integer minPrice, Integer maxPrice) {
        return bookRepository.findByPriceBetween(minPrice, maxPrice);
    }

    public List<Book> sortBooksByPriceAsc() {
        return bookRepository.findByOrderByPriceAsc();
    }

    // public void update(Book book) {
    // bookRepository.update(book);
    // }

    public List<Book> findByAuthorName(String author) {
        return bookRepository.findByAuthorName(author);
    }

    public Book findById(int id) {
        return bookRepository.findById(id).get();
    }

    public void addBook(Book book) {
        bookRepository.save(book);
    }

    public void updateBook(Book book) {
        bookRepository.save(book);
    }

    public void deleteBook(int id) {
        bookRepository.deleteById(id);
    }

    public List<Book> findByTitle(String title) {
        return bookRepository.findByTitleContainingIgnoreCase(title);
    }

    public List<Book> findByPublication(String publication) {
        return bookRepository.findByPublicationContainingIgnoreCase(publication);
    }

    public List<Book> findByPrice(Integer minPrice, Integer maxPrice) {
        return bookRepository.findByPriceBetween(minPrice, maxPrice);
    }
}
