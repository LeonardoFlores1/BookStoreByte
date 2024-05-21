package pruebaTecnica.bookStore.repository;

import org.jetbrains.annotations.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pruebaTecnica.bookStore.entity.book.Books;

@Repository
public interface BooksRepository extends JpaRepository<Books, Integer> {
    @NotNull
    Page<Books> findAll(@NotNull Pageable pageable);
}
