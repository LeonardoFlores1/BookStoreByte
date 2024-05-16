package pruebaTecnica.bookStore.dto.request.sale;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SaleDto {

    public int bookId;

    public String customerEmail;
}
