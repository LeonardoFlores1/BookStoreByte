package pruebaTecnica.bookStore.repository.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pruebaTecnica.bookStore.entity.book.Books;

import java.util.Optional;

public interface BookService {

    void save(Books books);

    Optional<Books> findById(Integer bookId);

    void deleteById(Integer bookId);

    Page<Books> findAll(Pageable pageable);
}
