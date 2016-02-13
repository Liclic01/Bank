package model;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by Алексей on 13.02.2016.
 */
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Date date;
    private double amount;
    private Account accountTo;
    private Account accountFrom;

    public Transaction() {
    }

    public Transaction(Date date, double amount, Account accountTo, Account accountFrom) {
        this.date = date;
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
