package com.springboot.assignment.magicofbooks.controller;

import com.springboot.assignment.magicofbooks.entity.Book;
import com.springboot.assignment.magicofbooks.entity.UserBook;
import com.springboot.assignment.magicofbooks.entity.Users;
import com.springboot.assignment.magicofbooks.service.BookService;
import com.springboot.assignment.magicofbooks.service.UserBookService;
import com.springboot.assignment.magicofbooks.service.UsersService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class DashboardController {
    @Autowired
    BookService bookService;

    @Autowired
    UserBookService userBookService;

    @Autowired
    UsersService usersService;


    @GetMapping("/dashboard")
    public String dashboardPage(HttpSession session, Map<String, List<Book>> map) {
        String email = (String) session.getAttribute("email");
        if (email == null)
            return "redirect:login";
        List<Book> books = this.bookService.getAllBooks();
        map.put("books", books);
        Users user = usersService.findByEmail((String) session.getAttribute("email"));
        List<UserBook> userBooks = userBookService.getFavorites(user);
        List<Book> favoriteBooks = new ArrayList<>();
        for (UserBook userBook : userBooks) {
            favoriteBooks.add(userBook.getBook());
        }
        map.put("favourites",favoriteBooks);
        userBooks = userBookService.getReadLater(user);
        List<Book> readLaterBooks = new ArrayList<>();
        for (UserBook userBook : userBooks) {
            readLaterBooks.add(userBook.getBook());
        }
        map.put("readlater",readLaterBooks);

        return "dashboard";
    }
}
