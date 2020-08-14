package com.greenfoxacademy.homework.controllers;

import com.greenfoxacademy.homework.Book;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BookController {

  private List<Book> books = new ArrayList<>();

  public BookController() {
    books.add(new Book("Eragon", "Christopher Paolini", 2002));
    books.add(new Book("The Da Vinci Code", "Dan Brown", 2003));
    books.add(new Book("The Day of the Triffids", "John Wyndham", 1951));
    books.add(new Book("The Hobbit, or There and Back Again", "J. R. R. Tolkien", 1937));
    books.add(new Book("Brisinger", "Christopher Paolini", 2008));
  }

  @GetMapping("/books")
  public String listBooks(Model model,
                          @RequestParam(name = "author", required = false) String author) {

    List<Book> queriedBooks;

    if (author != null) {
      queriedBooks = filterBooksByAuthor(author);
    } else {
      queriedBooks = books;
    }

    model.addAttribute("books", queriedBooks);
    return "index";
  }

  @GetMapping("/books/{id}")
  public String getBookById(Model model, @PathVariable("id") Integer id) {
    Book bookById = null;

    for(Book book : books) {
      if (book.getId() == id) {
        bookById = book;
      }
    }

    if (bookById != null) {
      model.addAttribute("book", bookById);
    } else {
      model.addAttribute("error", "No book found");
    }
    return "details";
  }

  @GetMapping("/books/add")
  public String addBook(Model model, @ModelAttribute("book") Book book) {
    model.addAttribute("book", book);
    return "addBook";
  }

  @PostMapping("/books/add")
  public String addBook(@ModelAttribute("book") Book book) {
    book.setNextId();
    books.add(book);
    return "redirect:/books";
  }

  private List<Book> filterBooksByAuthor(String author) {
    return books.stream()
        .filter(book -> book.getAuthor().equals(author))
        .collect(Collectors.toList());
  }
}
