package com.springboot.assignment.magicofbooks.controller;

import com.springboot.assignment.magicofbooks.entity.Book;
import com.springboot.assignment.magicofbooks.entity.Users;
import com.springboot.assignment.magicofbooks.service.BookService;
import com.springboot.assignment.magicofbooks.service.UserBookService;
import com.springboot.assignment.magicofbooks.service.UsersService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

//@RestController
@Controller
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;
    @Autowired
    private UsersService usersService;

    @Autowired
    private UserBookService userBookService;

    @PostMapping("/add")
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        return new ResponseEntity<>(bookService.saveBook(book), HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<Book>> getAllBooks() {
        return ResponseEntity.ok(bookService.getAllBooks());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBook(@PathVariable int id) {
        return ResponseEntity.ok(bookService.getBook(id));
    }

    @DeleteMapping("/delete/{id}")
    public void deleteBook(@PathVariable int id) {
        bookService.deleteBook(id);
    }

    @GetMapping("/search/author")
    public String searchByAuthor(Model model, @RequestParam("author") String author) {
        List<Book> books = bookService.findByAuthorName(author);
        model.addAttribute("books", books);
        return "searchList";
    }

    @GetMapping("/search/title")
    public String searchByTitle(Model model, @RequestParam("title") String title) {
        List<Book> books = bookService.findByTitle(title);
        model.addAttribute("books", books);
        return "searchList";
    }

    @GetMapping("/search/publication")
    public String searchByPublication(Model model, @RequestParam("publication") String publication) {
        List<Book> books = bookService.findByPublication(publication);
        model.addAttribute("books", books);
        return "searchList";
    }

    @GetMapping("/search/id")
    public String searchById(Model model, @RequestParam("id") Integer id) {
        System.out.println("ID" + id);
        Book book = bookService.findById(id);
        List<Book> books = new ArrayList<>();
        if (book != null) {
            books.add(book);
        }
        model.addAttribute("books", books);
        return "searchList";
    }

    @GetMapping("/search/priceRange")
    public String searchByPriceRange(Model model, @RequestParam("minPrice") Integer minPrice, @RequestParam("maxPrice") Integer maxPrice) {
        List<Book> books = bookService.findByPrice(minPrice, maxPrice);
        model.addAttribute("books", books);
        return "searchList";
    }

    @GetMapping("/sortByPriceASC")
    public String sortByPriceASC(Model model) {
        List<Book> books = bookService.sortBooksByPriceAsc();
        model.addAttribute("books", books);
        return "searchList";
    }

    @PostMapping("/add-to-favorites/{bookId}")
    public String addToFavorites(Model model, @PathVariable("bookId") int bookId, HttpSession session) {
        Users user = (Users) usersService.findByUsername(session.getAttribute("username").toString());
        Book book = bookService.findById(bookId);
        userBookService.addToFavorites(user, book);
        return "redirect:/dashboard";
    }

    @PostMapping("/read-later/{bookId}")
    public String readLater(Model model, @PathVariable("bookId") int bookId, HttpSession session) {
        Users user = (Users) usersService.findByUsername(session.getAttribute("username").toString());
        Book book = bookService.findById(bookId);
        userBookService.addToReadLater(user, book);
        return "redirect:/dashboard";
    }

    @PostMapping("/remove-from-favorites/{bookId}")
    public String removeFromFavorites(Model model, @PathVariable("bookId") int bookId, HttpSession session) {
        Users user = (Users) usersService.findByUsername(session.getAttribute("username").toString());
        Book book = bookService.findById(bookId);
        userBookService.removeFromFavorites(user, book);
        return "redirect:/dashboard";
    }

    @PostMapping("/remove-from-read-later/{bookId}")
    public String removeFromReadLater(Model model, @PathVariable("bookId") int bookId, HttpSession session) {
        Users user = (Users) usersService.findByUsername(session.getAttribute("username").toString());
        Book book = bookService.findById(bookId);
        userBookService.removeFromReadLater(user, book);
        return "redirect:/dashboard";
    }

}
