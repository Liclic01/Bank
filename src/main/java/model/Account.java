package model;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

/**
 * Created by Алексей on 13.02.2016.
 */
@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Date date;
    private double amount;
    @OneToMany(mappedBy = "account")
    private Collection<Transaction> transactions;


    public Account() {
    }

    public Account(Date date, double amount, Collection<Transaction> transactions) {

        this.date = date;
        this.amount = amount;
        this.transactions = transactions;

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Collection<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(Collection<Transaction> transactions) {
        this.transactions = transactions;
    }


}
