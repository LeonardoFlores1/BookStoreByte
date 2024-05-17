package pruebaTecnica.bookStore.entity.book;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "books")
@Data
public class Books {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public int bookId;
    public String title;
    public String description;
    public int stock;
    public double salePrice;
    public boolean available;
}
