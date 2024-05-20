package pruebaTecnica.bookStore.controller.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pruebaTecnica.bookStore.dto.request.book.BookDto;
import pruebaTecnica.bookStore.dto.response.book.BooksResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import pruebaTecnica.bookStore.entity.book.Books;
import pruebaTecnica.bookStore.service.BookStoreService;

import java.util.List;

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
    public ResponseEntity<BooksResponse> updateBook(@PathVariable(value = "bookId") int bookId, @RequestBody BookDto bookDto){
        try {
            BooksResponse booksResponse = bookStoreService.put(bookDto, bookId);
            return new ResponseEntity<>(booksResponse, HttpStatus.OK);
        } catch (Exception e){
            log.error(e.getMessage(), e);
            return new ResponseEntity<>(BooksResponse.builder().build(), HttpStatus.CONFLICT);
        }
    }
    //endpoint 3 delete

    @DeleteMapping("/books/{bookId}")
    public ResponseEntity<?> deleteBook(@PathVariable(value = "bookId") int bookId){
        bookStoreService.delete(bookId);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
    //endpoint 3 get
    @GetMapping("/books")
    public ResponseEntity<?> getAll(){
        List<Books> booksList = bookStoreService.get();

        if (booksList != null){
            if (!booksList.isEmpty()){
                return new ResponseEntity<>(booksList, HttpStatus.OK);
            } else {
                return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
            }
        } else {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
    }
}
