package pruebaTecnica.bookStore.entity.transaction;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "transactions")
@Data
public class Transaction {
    @Id
    public int id;

    public int bookId;

    public List<String> sales;

    public double totalRevenue;

    public List<String> customers;
}
