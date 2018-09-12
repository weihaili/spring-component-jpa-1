package org.com.kkl.entity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Boot {
	

	/**
	 * description step detail:
	 * 1. create EntityManagerFactory equality SessionFactory in hibernate
	 * 2. create EntityManager equality Session in hibernate
	 * 3. start transaction
	 * 4. execute persistence operation
	 * 5. submit transaction
	 * 6. close EntityManager
	 * 7. close EntityManagerFactoy
	 */
	public static void main(String[] args) {
		String persistenceUnitName="jpa-1";
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(persistenceUnitName);
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		
		Customer customer = new Customer();
		customer.setAge(18);
		customer.setEmail("tlp.hotmail.com");
		customer.setLastName("talap");
		
		entityManager.persist(customer);
		
		transaction.commit();
		
		entityManager.close();
		
		entityManagerFactory.close();
	}

}
