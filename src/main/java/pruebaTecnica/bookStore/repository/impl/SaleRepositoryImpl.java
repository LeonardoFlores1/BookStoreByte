package pruebaTecnica.bookStore.repository.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pruebaTecnica.bookStore.entity.sale.Sale;
import pruebaTecnica.bookStore.repository.SaleBooksRepository;
import pruebaTecnica.bookStore.repository.service.SaleRepositoryService;

import java.util.List;

@Slf4j
@Service
public class SaleRepositoryImpl implements SaleRepositoryService {

    @Autowired
    SaleBooksRepository saleRepository;

    @Override
    public void save(Sale sale) {
        saleRepository.save(sale);
    }

    @Override
    public List<Sale> findAll() {
        return saleRepository.findAll();
    }
}
