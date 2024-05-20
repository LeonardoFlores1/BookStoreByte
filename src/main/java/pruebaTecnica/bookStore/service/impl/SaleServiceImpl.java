package pruebaTecnica.bookStore.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pruebaTecnica.bookStore.dto.request.sale.SaleDto;
import pruebaTecnica.bookStore.dto.response.sale.SaleResponse;
import pruebaTecnica.bookStore.entity.book.Books;
import pruebaTecnica.bookStore.entity.sale.Sale;
import pruebaTecnica.bookStore.repository.impl.BookServiceImpl;
import pruebaTecnica.bookStore.repository.impl.SaleRepositoryImpl;
import pruebaTecnica.bookStore.service.SaleService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class SaleServiceImpl implements SaleService {

    @Autowired
    SaleRepositoryImpl saleRepository;

    @Autowired
    BookServiceImpl bookService;
    @Override
    public SaleResponse post(SaleDto saleDto) {

        try {
            SaleResponse saleResponse = new SaleResponse();
            Sale sale = new Sale();
            Books bookUpdate = new Books();
            Optional<Books> books = bookService.findById(saleDto.getBookId());

            if (books.isPresent()){
                sale.setBookId(saleDto.getBookId());
                sale.setCustomerId(saleDto.getCustomerEmail());
                sale.setPrice(books.get().getSalePrice());

                saleRepository.save(sale);

                bookUpdate.setBookId(saleDto.getBookId());
                bookUpdate.setTitle(books.get().getTitle());
                bookUpdate.setDescription(books.get().getDescription());
                bookUpdate.setSalePrice(books.get().getSalePrice());
                bookUpdate.setAvailable(books.get().getStock() >= 1);
                bookUpdate.setStock(books.get().getStock() - 1);

                bookService.save(bookUpdate);
                saleResponse.setBookId(saleDto.getBookId());
                saleResponse.setCustomerEmail(saleDto.getCustomerEmail());
                saleResponse.setPrice(books.get().getSalePrice());
            }

            return saleResponse;
        } catch (Exception e){
            log.error(e.getMessage(), e);
            return null;
        }
    }
}
