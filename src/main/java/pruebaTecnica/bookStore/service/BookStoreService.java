package pruebaTecnica.bookStore.service;

import pruebaTecnica.bookStore.dto.request.book.BookDto;
import pruebaTecnica.bookStore.dto.response.book.BooksResponse;

public interface BookStoreService {

    BooksResponse post(BookDto bookDto);
}
