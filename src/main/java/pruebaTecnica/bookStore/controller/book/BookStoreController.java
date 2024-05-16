package pruebaTecnica.bookStore.controller.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pruebaTecnica.bookStore.dto.request.book.BookDto;
import pruebaTecnica.bookStore.dto.response.book.BooksResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import pruebaTecnica.bookStore.service.BookStoreService;

@Slf4j
@RestController
@RequestMapping
public class BookStoreController {

    @Autowired
    BookStoreService bookStoreService;

    //endpoint 1 post
    @PostMapping("/books")
    public ResponseEntity<BooksResponse> saveBook(@RequestBody BookDto bookDto){
        try {
            BooksResponse booksResponse = bookStoreService.post(bookDto);
            return new ResponseEntity<>(booksResponse, HttpStatus.CREATED);
        } catch (Exception e){
            log.error(e.getMessage(), e);
            return new ResponseEntity<>(BooksResponse.builder().build(), HttpStatus.CONFLICT);
        }
    }
    //endpoint 2 put
    @PutMapping("/books/{bookId}")
    public ResponseEntity<BooksResponse> updateBook(int bookId, @RequestBody BookDto bookDto){
        try {
            BooksResponse booksResponse = bookStoreService.post(bookDto);
            return new ResponseEntity<>(booksResponse, HttpStatus.CREATED);
        } catch (Exception e){
            log.error(e.getMessage(), e);
            return new ResponseEntity<>(BooksResponse.builder().build(), HttpStatus.CONFLICT);
        }
    }
    //endpoint 3 delete

    //endpoint 3 get
}
