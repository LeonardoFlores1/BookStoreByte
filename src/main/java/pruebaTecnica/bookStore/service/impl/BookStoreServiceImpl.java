package pruebaTecnica.bookStore.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pruebaTecnica.bookStore.dto.request.book.BookDto;
import pruebaTecnica.bookStore.dto.response.book.Books;
import pruebaTecnica.bookStore.dto.response.book.BooksResponse;
import pruebaTecnica.bookStore.service.BookStoreService;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class BookStoreServiceImpl implements BookStoreService{
    @Override
    public BooksResponse post(BookDto bookDto) {
        try {
            BooksResponse booksResponse = new BooksResponse();

            booksResponse.setBookId(1);
            booksResponse.setTitle(bookDto.getTitle());
            booksResponse.setDescription(bookDto.getDescription());
            booksResponse.setStock(bookDto.getStock());
            booksResponse.setSalePrice(bookDto.getSalePrice());
            booksResponse.setAvailable(bookDto.isAvailable());

            return booksResponse;
        } catch (Exception e) {
            log.error(e.getMessage());
            return BooksResponse.builder().build();
        }
    }
}
