package pruebaTecnica.bookStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pruebaTecnica.bookStore.entity.book.Books;

@Repository
public interface BooksRepository extends JpaRepository<Books, Integer> {

}
