package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import entidade.Local;
import util.JPAUtil;

public class LocalDao {
	public static void salvar(Local local) {
		 EntityManager em = JPAUtil.criarEntityManager();  //Cria um novo EntityManager
		 em.getTransaction().begin(); 					   //Inicia a Transação no BD
		 em.persist(local); 							   //Persiste e manda para o BD
		 em.getTransaction().commit(); 					   //Faz o INSERT no BD e Sincroniza
		 em.close(); 									   // e ENCERRA o processo
	}
	
	public static List<Local> listar(){
		EntityManager em = JPAUtil.criarEntityManager();
		Query query = em.createQuery("select a from Local a");
		List<Local> locais = query.getResultList();
		return locais;
	}
}
