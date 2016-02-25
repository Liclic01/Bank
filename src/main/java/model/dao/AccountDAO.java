package model.dao;

import model.Account;
import org.springframework.data.repository.CrudRepository;


public interface AccountDAO extends CrudRepository<Account,Long>{
}
