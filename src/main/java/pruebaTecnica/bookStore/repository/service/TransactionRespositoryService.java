package pruebaTecnica.bookStore.repository.service;

import pruebaTecnica.bookStore.entity.sale.Sale;

import java.util.Date;
import java.util.List;

public interface TransactionRespositoryService {
    List<Sale> findByIdAndDateBetween(Integer bookId, Date from, Date to);
}
