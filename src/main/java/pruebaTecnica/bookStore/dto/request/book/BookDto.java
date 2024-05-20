package pruebaTecnica.bookStore.dto.request.book;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class BookDto {

    public String title;

    public String description;

    public int stock;

    public Double salePrice;

    public boolean available;
}
