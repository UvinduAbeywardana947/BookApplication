package com.example.BookApplication.Service;

import com.example.BookApplication.Entity.Book;
import com.example.BookApplication.Repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    @Autowired
    BookRepo bookRepo;
    public Book addBook(Book book) {
        return bookRepo.save(book);
    }

    public Book getBookById(Integer id) {
        return bookRepo.findById(id).orElse(null);
    }

    public Book updateBook(Book book) {
        return bookRepo.save(book);
    }

    public void deleteBookById(Integer id) {
        bookRepo.deleteById(id);
    }
}
