package model;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Transaction {
    @Id
    @GeneratedValue
    private long id;
    private Date date;
    private double amount;
    @ManyToOne
    private Account accountTo;
    @ManyToOne
    private Account accountFrom;

    public Transaction() {
    }

    public Transaction(double amount, Account accountTo, Account accountFrom) {
        this.date = new Date(new java.util.Date().getTime());
        this.amount = amount;
        this.accountTo = accountTo;
        this.accountFrom = accountFrom;
        accountFrom.setAmount(accountFrom.getAmount()-amount);
        accountTo.setAmount(accountTo.getAmount()+amount);

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

    public Account getAccountTo() {
        return accountTo;
    }

    public void setAccountTo(Account accountTo) {
        this.accountTo = accountTo;
    }

    public Account getAccountFrom() {
        return accountFrom;
    }

    public void setAccountFrom(Account accountFrom) {
        this.accountFrom = accountFrom;
    }
}
