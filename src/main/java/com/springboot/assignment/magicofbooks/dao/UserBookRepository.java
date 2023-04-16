package com.springboot.assignment.magicofbooks.dao;

import com.springboot.assignment.magicofbooks.entity.Book;
import com.springboot.assignment.magicofbooks.entity.UserBook;
import com.springboot.assignment.magicofbooks.entity.Users;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserBookRepository extends JpaRepository<UserBook, Long> {

    List<UserBook> findByUserAndIsFavorite(Users user, boolean b);

    List<UserBook> findByUserAndIsReadLater(Users user, boolean b);

    @Modifying
    @Transactional
    @Query("delete from UserBook ub where ub.user = :user and ub.book = :book and ub.isFavorite = true")
    void deleteByUserAndBookAndFavoriteIsTrue(@Param("user") Users user, @Param("book") Book book);

    @Modifying
    @Transactional
    @Query("delete from UserBook ub where ub.user = :user and ub.book = :book and ub.isReadLater = true")
    void deleteByUserAndBookAndReadLaterTrue(@Param("user") Users user, @Param("book") Book book);

}
