package pruebaTecnica.bookStore.service;

import pruebaTecnica.bookStore.dto.request.sale.SaleDto;
import pruebaTecnica.bookStore.dto.response.sale.SaleResponse;

public interface SaleService {

    SaleResponse post(SaleDto saleDto);
}
