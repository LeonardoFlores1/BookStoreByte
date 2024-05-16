package pruebaTecnica.bookStore.dto.request.like;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class LikeDto {

    public int bookId;

    public String customerEmail;
}
