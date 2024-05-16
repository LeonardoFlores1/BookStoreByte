package pruebaTecnica.bookStore.dto.response.like;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class LikeResponse {

    public int bookId;

    public int likes;

    public List<String> customers;
}
