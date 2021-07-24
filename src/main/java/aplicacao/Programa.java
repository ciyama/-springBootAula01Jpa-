package aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Dominio.Pessoa;

public class Programa {
	
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = emf.createEntityManager();
		
		//Pessoa p = new Pessoa(2, null, null); //detached para contornar este erro faremos um find para recuperar o usuario do banco
		Pessoa p = em.find(Pessoa.class, 2);
		//iniciar a transaction
		em.getTransaction().begin();
		em.remove(p);
		em.getTransaction().commit();
		
		System.out.println("Pronto!");
		em.close();
		emf.close();
	}

}
