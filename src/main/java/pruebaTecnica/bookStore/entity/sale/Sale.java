package pruebaTecnica.bookStore.entity.sale;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;
import java.util.Date;

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

    @Temporal(TemporalType.DATE)
    Date date;

    @PrePersist
    public void prePersist() {date = new Date();}
}
