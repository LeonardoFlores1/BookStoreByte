package pruebaTecnica.bookStore.repository.service;

import pruebaTecnica.bookStore.entity.sale.Sale;

import java.util.List;
import java.util.Optional;

public interface SaleRepositoryService {
    void save(Sale sale);

    List<Sale> findAll();
}
