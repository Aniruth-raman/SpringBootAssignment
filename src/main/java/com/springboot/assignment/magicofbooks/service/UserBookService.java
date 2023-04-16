package com.springboot.assignment.magicofbooks.service;

import com.springboot.assignment.magicofbooks.dao.UserBookRepository;
import com.springboot.assignment.magicofbooks.entity.Book;
import com.springboot.assignment.magicofbooks.entity.UserBook;
import com.springboot.assignment.magicofbooks.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserBookService {

    @Autowired
    private UserBookRepository userBookRepository;

    public void addToFavorites(Users user, Book book) {
        UserBook userBook = new UserBook();
        userBook.setUser(user);
        userBook.setBook(book);
        userBook.setFavorite(true);
        userBook.setReadLater(false);
        userBookRepository.save(userBook);
    }

    public void addToReadLater(Users user, Book book) {
        UserBook userBook = new UserBook();
        userBook.setUser(user);
        userBook.setBook(book);
        userBook.setFavorite(false);
        userBook.setReadLater(true);
        userBookRepository.save(userBook);
    }

    public List<UserBook> getFavorites(Users user) {
        return userBookRepository.findByUserAndIsFavorite(user, true);
    }

    public List<UserBook> getReadLater(Users user) {
        return userBookRepository.findByUserAndIsReadLater(user, true);
    }

    public void removeFromFavorites(Users user, Book book) {
        userBookRepository.deleteByUserAndBookAndFavoriteIsTrue(user, book);
    }

    public void removeFromReadLater(Users user, Book book) {
        userBookRepository.deleteByUserAndBookAndReadLaterTrue(user, book);
    }
}
