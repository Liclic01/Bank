package model.dao;

import java.util.List;

import model.Client;

import org.springframework.data.repository.CrudRepository;

public interface ClientDAO extends CrudRepository<Client, Long>  {	
}
