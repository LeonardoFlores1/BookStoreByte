package pruebaTecnica.bookStore.repository.service;

import pruebaTecnica.bookStore.dto.request.book.BookDto;
import pruebaTecnica.bookStore.entity.book.Books;

import java.util.List;
import java.util.Optional;

public interface BookService {

    public void save(Books books);

    public Optional<Books> findById(Integer bookId);

    public void deleteById(Integer bookId);

    public List<Books> findAll();
}
