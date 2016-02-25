package model.dao;

import model.Transaction;
import org.springframework.data.repository.CrudRepository;


public interface TransactionDAO extends CrudRepository<Transaction,Long> {
}
