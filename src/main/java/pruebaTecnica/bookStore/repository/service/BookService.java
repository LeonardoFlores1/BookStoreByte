package pruebaTecnica.bookStore.repository.service;

import pruebaTecnica.bookStore.entity.book.Books;

import java.util.List;
import java.util.Optional;

public interface BookService {

    void save(Books books);

    Optional<Books> findById(Integer bookId);

    void deleteById(Integer bookId);

    List<Books> findAll();
}
