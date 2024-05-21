package pruebaTecnica.bookStore.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pruebaTecnica.bookStore.dto.response.transaction.TransactionResponse;
import pruebaTecnica.bookStore.entity.sale.Sale;
import pruebaTecnica.bookStore.repository.impl.TransactionRespositoryImpl;
import pruebaTecnica.bookStore.repository.service.SaleRepositoryService;
import pruebaTecnica.bookStore.service.TransactionService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class TransactionServiceImpl implements TransactionService {
    @Autowired
    TransactionRespositoryImpl respository;

    @Autowired
    SaleRepositoryService saleRepositoryService;
    @Override
    public TransactionResponse findTransaction(int bookId, Date from, Date to) {
        try {
            List<Sale> sales = respository.findByIdAndDateBetween(bookId, from, to);
            TransactionResponse transactionResponse = new TransactionResponse();
            List<String> customerList = new ArrayList<>();
            List<String> dates = new ArrayList<>();
            double revenue = 0.0;

            for (Sale sale: sales){
                customerList.add(sale.getCustomerId());
                revenue += sale.getPrice();
            }

            dates.add(String.valueOf(to));
            dates.add(String.valueOf(from));

            transactionResponse.setBookId(bookId);
            transactionResponse.setSales(dates);
            transactionResponse.setTotalRevenue(revenue);
            transactionResponse.setCustomers(customerList);

            return transactionResponse;
        } catch (Exception e){
            log.error(e.getMessage(),e);
            return null;
        }
    }
}
