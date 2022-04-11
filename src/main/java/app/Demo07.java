package app;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Usuario;

public class Demo07 {
	public static void main(String[] args) {
		//Lista de los usuarios segun el tipo
		

		// Listado de todos los usuarios
		
		//Fabrica --> DAO
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");	
		EntityManager em = fabrica.createEntityManager();	
				
		//Select * from tb_usuarios
		TypedQuery<Usuario> consulta =
				em.createQuery("Select u from Usuario u where tipo = :xtipo", Usuario.class);
		
		consulta.setParameter("xtipo", 1);
		List<Usuario> lstUsuarios = consulta.getResultList();
		
		for (Usuario u : lstUsuarios) {
			System.out.println(u);
		}
		
		//Cierre
		em.close();
	
	
		
	}
	
	

}
