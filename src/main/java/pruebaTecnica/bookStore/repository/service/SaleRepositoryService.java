package pruebaTecnica.bookStore.repository.service;

import pruebaTecnica.bookStore.entity.sale.Sale;

import java.util.List;

public interface SaleRepositoryService {
    void save(Sale sale);

    List<Sale> findAll();
}
