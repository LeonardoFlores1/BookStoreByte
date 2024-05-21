package pruebaTecnica.bookStore.dto.request.book;


import lombok.*;
import org.springframework.stereotype.Component;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Component
public class BookDto {


    public String title;

    public String description;

    public int stock;

    public Double salePrice;

    public boolean available;
}
