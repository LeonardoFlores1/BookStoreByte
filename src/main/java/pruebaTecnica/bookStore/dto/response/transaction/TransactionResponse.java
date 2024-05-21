package pruebaTecnica.bookStore.dto.response.transaction;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class TransactionResponse {

    public int bookId;

    public List<String> sales;

    public double totalRevenue;

    public List<String> customers;
}
