package pruebaTecnica.bookStore.controller.sale;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pruebaTecnica.bookStore.dto.request.sale.SaleDto;
import pruebaTecnica.bookStore.dto.response.sale.SaleResponse;
import pruebaTecnica.bookStore.service.SaleService;

@Slf4j
@RestController
@RequestMapping
public class SaleController {
    @Autowired
    SaleService saleService;

    @PostMapping("/sales")
    public ResponseEntity<SaleResponse> postSale(@RequestBody SaleDto saleDto){
        try {
            SaleResponse saleResponse = saleService.post(saleDto);
            return new ResponseEntity<>(saleResponse, HttpStatus.CREATED);
        } catch (Exception e){
            log.error(e.getMessage(), e);
            return new ResponseEntity<>(SaleResponse.builder().build(), HttpStatus.CONFLICT);
        }
    }
}
