package pruebaTecnica.bookStore.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pruebaTecnica.bookStore.dto.request.book.BookDto;
import pruebaTecnica.bookStore.dto.response.book.BooksResponse;
import pruebaTecnica.bookStore.entity.book.Books;
import pruebaTecnica.bookStore.repository.impl.BookServiceImpl;
import pruebaTecnica.bookStore.service.BookStoreService;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class BookStoreServiceImpl implements BookStoreService{
    @Autowired
    BookServiceImpl bookService;
    @Override
    public BooksResponse post(BookDto bookDto) {
        try {
            BooksResponse booksResponse = new BooksResponse();
            Books books = new Books();

            books.setTitle(bookDto.getTitle());
            books.setDescription(bookDto.getDescription());
            books.setStock(bookDto.getStock());
            books.setSalePrice(bookDto.getSalePrice());
            books.setAvailable(bookDto.isAvailable());

            bookService.save(books);
            Optional<Books> books1 = bookService.findById(books.getBookId());

            if (books1.isPresent()){
                booksResponse.setBookId(books1.get().getBookId());
                booksResponse.setTitle(books1.get().getTitle());
                booksResponse.setDescription(books1.get().getDescription());
                booksResponse.setStock(books1.get().getStock());
                booksResponse.setAvailable(books1.get().isAvailable());
                booksResponse.setSalePrice(books1.get().getSalePrice());
            }

            return booksResponse;
        } catch (Exception e) {
            log.error(e.getMessage());
            return BooksResponse.builder().build();
        }
    }

    @Override
    public BooksResponse put(BookDto bookDto) {
        try {
            BooksResponse booksResponse = new BooksResponse();
            Books books = new Books();

            books.setTitle(bookDto.getTitle());
            books.setDescription(bookDto.getDescription());
            books.setStock(bookDto.getStock());
            books.setSalePrice(bookDto.getSalePrice());
            books.setAvailable(bookDto.isAvailable());

            bookService.save(books);
            Optional<Books> books1 = bookService.findById(books.getBookId());

            if (books1.isPresent()){
                booksResponse.setBookId(books1.get().getBookId());
                booksResponse.setTitle(books1.get().getTitle());
                booksResponse.setDescription(books1.get().getDescription());
                booksResponse.setStock(books1.get().getStock());
                booksResponse.setAvailable(books1.get().isAvailable());
                booksResponse.setSalePrice(books1.get().getSalePrice());
            }

            return booksResponse;
        } catch (Exception e){
            log.error(e.getMessage());
            return BooksResponse.builder().build();
        }
    }

    @Override
    public List<Books> get() {
        return bookService.findAll();
    }
}
