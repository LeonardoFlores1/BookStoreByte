package pruebaTecnica.bookStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pruebaTecnica.bookStore.entity.sale.Sale;

@Repository
public interface SaleBooksRepository extends JpaRepository<Sale, Integer> {

}
