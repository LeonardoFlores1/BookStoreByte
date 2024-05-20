package pruebaTecnica.bookStore.entity.sale;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "sales")
@Data
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    public int bookId;

    public String customerId;

    public double price;
}
