package pruebaTecnica.bookStore.service;

import pruebaTecnica.bookStore.dto.request.book.BookDto;
import pruebaTecnica.bookStore.dto.response.book.BooksResponse;
import pruebaTecnica.bookStore.entity.book.Books;

import java.util.List;

public interface BookStoreService {

    BooksResponse post(BookDto bookDto);

    BooksResponse put(BookDto bookDto);

    List<Books> get();
}
