package pruebaTecnica.bookStore.repository.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pruebaTecnica.bookStore.entity.book.Books;
import pruebaTecnica.bookStore.repository.BooksRepository;
import pruebaTecnica.bookStore.repository.service.BookService;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class BookServiceImpl implements BookService {
    @Autowired
    BooksRepository repository;

    @Override
    public void save(Books books) {
        repository.save(books);
    }

    @Override
    public Optional<Books> findById(Integer bookId) {
        return repository.findById(bookId);
    }

    @Override
    public void deleteById(Integer bookId) {

    }

    @Override
    public List<Books> findAll() {
        return repository.findAll();
    }
}
