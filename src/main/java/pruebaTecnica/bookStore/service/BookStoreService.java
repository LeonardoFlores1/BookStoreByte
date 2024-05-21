package pruebaTecnica.bookStore.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pruebaTecnica.bookStore.dto.request.book.BookDto;
import pruebaTecnica.bookStore.dto.response.book.BooksResponse;
import pruebaTecnica.bookStore.entity.book.Books;

import java.util.List;

public interface BookStoreService {

    BooksResponse post(BookDto bookDto);

    BooksResponse put(BookDto bookDto, Integer bookId);

    Page<Books> get(Pageable pageable);

    void delete(Integer bookId);
}
