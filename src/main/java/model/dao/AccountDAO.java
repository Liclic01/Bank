package model.dao;

import model.Account;
import org.springframework.data.repository.CrudRepository;
/**
 * Created by Алексей on 13.02.2016.
 */

public interface AccountDAO extends CrudRepository<Account,Long>{
}
