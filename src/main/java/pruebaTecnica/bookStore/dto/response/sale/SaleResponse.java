package pruebaTecnica.bookStore.dto.response.sale;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class SaleResponse {

    public int bookId;

    public String customerEmail;

    public double price;
}
