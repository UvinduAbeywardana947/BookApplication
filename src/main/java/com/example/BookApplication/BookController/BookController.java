package com.example.BookApplication.BookController;

import com.example.BookApplication.Entity.Book;
import com.example.BookApplication.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/v1")
public class BookController {
    // constructor-based dependency injection
    @Autowired
    private BookService bookService;
    //create method
    @PostMapping(value = "/addBook")
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        Book savedBook = bookService.addBook(book);
        return ResponseEntity.ok(savedBook);
        //Using ResponseEntity.ok(savedBook) is a convenient way to
        // create and return a complete HTTP response with a 200 status code and a body containing the
        // saved entity.
    }
    //read method
    @GetMapping(value = "/getBook/{id}")
    public ResponseEntity<Book> getBook(@PathVariable Integer id){
        Book bookId = bookService.getBookById(id);
        return ResponseEntity.ok(bookId);
    }
    //update method
    @PutMapping(value = "/updateBook")
    public ResponseEntity<Book> updateBook(@RequestBody Book book){
        Book updatedBook = bookService.updateBook(book);
        return ResponseEntity.ok(updatedBook);
    }
    //delete method
    @DeleteMapping(value = "/deleteBook")
    public ResponseEntity<Book> deleteBook(@PathVariable Integer id){
        bookService.deleteBookById(id);
        //build(): This method finalizes the ResponseEntity without adding a body. It returns a
        // HTTP 200 OK status and no body.
        return ResponseEntity.ok().build();

    }


}
