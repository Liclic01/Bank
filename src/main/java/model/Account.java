package model;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;


@Entity
public class Account {

    @Id
    @GeneratedValue
    private long id;
    private Date date;
    private double amount;
    @OneToMany
	@JoinTable(name = "account_transaction", joinColumns = @JoinColumn(name = "account_id"), inverseJoinColumns = @JoinColumn(name = "transaction_id"))
    private Collection<Transaction> transactions = new ArrayList<>();


    public Account() {
    }

    public Account(double amount) {
        this.date = new Date(new java.util.Date().getTime());
        this.amount = amount;

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
