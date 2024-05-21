package pruebaTecnica.bookStore.controller.transaction;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pruebaTecnica.bookStore.dto.response.transaction.TransactionResponse;
import pruebaTecnica.bookStore.service.TransactionService;

import java.util.Date;

@Slf4j
@RestController
@RequestMapping
public class TransactionController {
    @Autowired
    TransactionService transactionService;

    @GetMapping("/transactions/books/{bookId}")
    public ResponseEntity<TransactionResponse> getTransactions(@PathVariable(value = "bookId") int bookid,
                                                               @RequestParam(name = "from") @DateTimeFormat(pattern = "yyyy-MM-dd") Date from,
                                                               @RequestParam(name = "to") @DateTimeFormat(pattern = "yyyy-MM-dd") Date to){

        try {
            TransactionResponse transactionResponse = transactionService.findTransaction(bookid, from, to);
            return new ResponseEntity<>(transactionResponse, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(TransactionResponse.builder().build(), HttpStatus.CONFLICT);
        }

    }
}
