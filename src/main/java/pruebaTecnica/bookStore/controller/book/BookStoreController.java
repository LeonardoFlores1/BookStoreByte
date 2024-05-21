package pruebaTecnica.bookStore.controller.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pruebaTecnica.bookStore.dto.request.book.BookDto;
import pruebaTecnica.bookStore.dto.response.book.BooksResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import pruebaTecnica.bookStore.entity.book.Books;
import pruebaTecnica.bookStore.service.BookStoreService;

@Slf4j
@RestController
@RequestMapping
@Validated
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
    public ResponseEntity<Page<Books>> getAll(@RequestParam(defaultValue = "0") int page,
                                              @RequestParam(defaultValue = "12") int size){

        Pageable pageable = PageRequest.of(page, size);
        Page<Books> booksList= bookStoreService.get(pageable);

        if (!booksList.isEmpty()) {
            return new ResponseEntity<>(booksList, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
