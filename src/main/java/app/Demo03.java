package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demo03 {

	public static void main(String[] args) {
		// Eliminar un nuevo usuario
		
		
		//Fabrica --> DAO
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");	
		//Manejar Entidades
		EntityManager em = fabrica.createEntityManager();	
		
		em.getTransaction().begin();
		
		
		Usuario u = new Usuario();
		u.setCodigo(10);
		
		
		em.remove(u);// !!CUIDADO!!.. Nesecita un objeto que se debe devolver
		//confirmacion
		em.getTransaction().commit();
		//Cierre
		em.close();
		

		

	}



}
