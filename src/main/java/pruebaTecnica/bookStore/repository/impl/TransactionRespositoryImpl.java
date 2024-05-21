package pruebaTecnica.bookStore.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pruebaTecnica.bookStore.entity.sale.Sale;
import pruebaTecnica.bookStore.repository.TransactionBookRepository;
import pruebaTecnica.bookStore.repository.service.TransactionRespositoryService;

import java.util.Date;
import java.util.List;

@Service
public class TransactionRespositoryImpl implements TransactionRespositoryService {
    @Autowired
    TransactionBookRepository transactionBookRepository;
    @Override
    public List<Sale> findByIdAndDateBetween(Integer bookId, Date from, Date to) {
        try {
            return transactionBookRepository.findByIdAndDateBetween(bookId,from,to);
        } catch (Exception e){
            return null;
        }
    }
}
