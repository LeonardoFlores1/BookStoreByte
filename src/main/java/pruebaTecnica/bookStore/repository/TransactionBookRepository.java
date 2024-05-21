package pruebaTecnica.bookStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pruebaTecnica.bookStore.entity.sale.Sale;
import pruebaTecnica.bookStore.entity.transaction.Transaction;

import java.util.Date;
import java.util.List;

@Repository
public interface TransactionBookRepository extends JpaRepository<Sale, Integer> {
    @Transactional
    @Query("select s from Sale s where s.bookId = :bookId and s.date >= :from and s.date <= :to")
    List<Sale> findByIdAndDateBetween(@Param("bookId")Integer bookId,
                                      @Param("from") Date from,
                                      @Param("to") Date to);
}
