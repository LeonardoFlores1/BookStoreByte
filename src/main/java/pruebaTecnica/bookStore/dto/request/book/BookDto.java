package pruebaTecnica.bookStore.dto.request.book;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class BookDto {

    @NotNull
    @NotEmpty
    public String title;

    public String description;

    @NotNull
    @NotEmpty
    public int stock;

    @NotNull
    @NotEmpty
    public Double salePrice;

    public boolean available;
}
