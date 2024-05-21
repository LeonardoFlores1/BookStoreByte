package pruebaTecnica.bookStore.repository.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
        repository.deleteById(bookId);
    }

    @Override
    public Page<Books> findAll(Pageable pageable) {
        try {
            return repository.findAll(pageable);
        } catch (Exception e){
            log.error(e.getMessage(), e);
            return null;
        }
    }
}
