package model.dao;

import model.Transaction;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Алексей on 13.02.2016.
 */
public interface TransactionDAO extends CrudRepository<Transaction,Long> {
}
