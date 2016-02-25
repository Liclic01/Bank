package model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;

import model.dao.AccountDAO;
import model.dao.ClientDAO;

@SpringBootApplication
@PropertySource("classpath:application.properties")
public class Application {
	

	private static final Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Application.class);
	}

	@Bean
	public CommandLineRunner demo(ClientDAO repository, AccountDAO accrep) {
		return (args) -> {
			List<Client> clients = new ArrayList<>();
			clients.add(new Client("Jack", "Bauer", new SimpleDateFormat("dd.MM.yyyy").parse("21.11.1991")));
			clients.add(new Client("Chloe", "O'Brian", new SimpleDateFormat("dd.MM.yyyy").parse("10.01.1988")));
			clients.add(new Client("Kim", "Bauer", new SimpleDateFormat("dd.MM.yyyy").parse("15.10.1990")));
			clients.add(new Client("David", "Palmer", new SimpleDateFormat("dd.MM.yyyy").parse("07.03.1991")));
			clients.add(new Client("Michelle", "Dessler", new SimpleDateFormat("dd.MM.yyyy").parse("28.11.1993")));
			List<Account> accounts1 = new ArrayList<>();
			accounts1.add(new Account(235));
			accounts1.add(new Account(25));
			accounts1.add(new Account(2335));
			List<Account> accounts2 = new ArrayList<>();
			accounts2.add(new Account(1235));
			accounts2.add(new Account(98));
			List<Account> accounts3 = new ArrayList<>();
			accounts3.add(new Account(908));
			List<Account> accounts4 = new ArrayList<>();
			accounts4.add(new Account(90));
			accounts4.add(new Account(7690));
			List<Account> accounts5 = new ArrayList<>();
			accounts5.add(new Account(690));
			List<List<Account>> accounts = new ArrayList<>();
			accounts.add(accounts1);
			accounts.add(accounts2);
			accounts.add(accounts3);
			accounts.add(accounts4);
			accounts.add(accounts5);
			for (int i = 0; i < clients.size(); i++) {
				Client client = clients.get(i);
				List<Account> accs = accounts.get(i);
				client.setAccounts(accs);
				accrep.save(accs);
				repository.save(client);
			} 
			log.info("Customers found with findAll():");
			log.info("-------------------------------");
			for (Client client : repository.findAll()) {
				log.info(client.toString());
			}
            log.info("");

			// fetch an individual customer by ID
			Client client = repository.findOne(1L);
			log.info("Customer found with findOne(1L):");
			log.info("--------------------------------");
			log.info(client.toString());
            log.info("");

		};
	}

}
