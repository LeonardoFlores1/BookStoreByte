package pruebaTecnica.bookStore.dto.response.book;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Books {
    public int bookId;
    public String title;
    public String description;
    public int stock;
    public double salePrice;
    public boolean available;
}
