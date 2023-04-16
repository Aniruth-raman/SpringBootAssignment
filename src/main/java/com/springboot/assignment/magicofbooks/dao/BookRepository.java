package com.springboot.assignment.magicofbooks.dao;

import com.springboot.assignment.magicofbooks.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    List<Book> findByAuthorNameContainingIgnoreCase(String authorName);

    List<Book> findByTitleContainingIgnoreCase(String title);

    List<Book> findByPublicationContainingIgnoreCase(String publication);

    List<Book> findByPriceBetween(Integer minPrice, Integer maxPrice);

    List<Book> findByOrderByPriceAsc();

    List<Book> findByAuthorName(String author);

}
