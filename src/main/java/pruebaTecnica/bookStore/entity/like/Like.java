package pruebaTecnica.bookStore.entity.like;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "likes")
@Data
public class Like {

    @Id
    public int bookId;

    public int likes;

    public List<String> customers;
}
