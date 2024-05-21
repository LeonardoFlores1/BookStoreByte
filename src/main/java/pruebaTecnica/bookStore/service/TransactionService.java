package pruebaTecnica.bookStore.service;

import pruebaTecnica.bookStore.dto.response.transaction.TransactionResponse;

import java.util.Date;

public interface TransactionService {

    TransactionResponse findTransaction(int bookId, Date from, Date to);
}
