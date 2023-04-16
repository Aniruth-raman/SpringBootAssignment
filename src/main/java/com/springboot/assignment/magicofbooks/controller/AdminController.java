package com.springboot.assignment.magicofbooks.controller;

import com.springboot.assignment.magicofbooks.entity.Book;
import com.springboot.assignment.magicofbooks.service.BookService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class AdminController {

    @Autowired
    BookService bookService;

    @GetMapping("/admin")
    public String adminPage(HttpSession session, Map<String, List<Book>> map) {
        String email = (String) session.getAttribute("email");
        if (email == null) return "redirect:login";
        else if (!email.equals("admin@admin.com")) {
            return "redirect:login?error=You are not an authorised admin user";
        }
        List<Book> books = this.bookService.getAllBooks();
        System.out.println(books);
        map.put("books", books);
        return "admin";
    }

    public List<Book> listAllBooks() {
        return bookService.getAllBooks();
    }

    public void addNewBook(Book book) {
        bookService.saveBook(book);
    }

    public void removeBookByID(int id) {
        bookService.deleteBook(id);
    }

    // handle GET request for add/update book form
    @GetMapping("/admin/form")
    public String showBookForm(Model model) {
        Book book = new Book();
        model.addAttribute("book", book);
        return "book-form";
    }

    // handle POST request for add/update book form
    @PostMapping("/admin/book/save")
    public String saveBook(@ModelAttribute("Book") Book book) {
        if (book.getId() == 0) {
            bookService.addBook(book);
        } else {
            bookService.updateBook(book);
        }
        return "redirect:/admin";
    }


    @PostMapping("/admin/book/delete/{id}")
    public String deleteBook(@PathVariable("id") int id) {
        System.out.println("Delete ID:" + id);
        bookService.deleteBook(id);
        return "redirect:/admin";
    }

    @GetMapping("/admin/book/edit/{id}")
    public String editBook(@PathVariable("id") int id, Model model) {
        System.out.println("Edit ID:" + id);
        Book book = bookService.findById(id);
        model.addAttribute("Book", book);
        return "book-form";
    }

    @GetMapping("/admin/books/search")
    public String searchBooks(Model model, @RequestParam(required = false) Integer id, @RequestParam(required = false) String author) {
        List<Book> books = new ArrayList<>();

        if (id != null) {
            Book book = bookService.findById(id);
            if (book != null) {
                books.add(book);
            }
        } else if (author != null) {
            books = bookService.findByAuthorName(author);
        }

        model.addAttribute("books", books);
        return "searchList";
    }


    @ModelAttribute("Book")
    public Book getBook() {
        return new Book();
    }

//    @GetMapping("/admin/books/list")
//    public String bookList() {
//        return "booksList";
//    }
    // public void updateBook(Book book) {
    // bookService.update(book);
    // }
}
