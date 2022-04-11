package app;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Usuario;

public class Demo06 {
	public static void main(String[] args) {
		// Listado de todos los usuarios
		
		//Fabrica --> DAO
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");	
		EntityManager em = fabrica.createEntityManager();	
		//empieza el proceso de listado ---- em.getTransaction().begin();
				
		//Select * from tb_usuarios
		TypedQuery<Usuario> consulta = em.createQuery("Select u from Usuario u", Usuario.class);
		

		List<Usuario> lstUsuarios = consulta.getResultList();
		
		for (Usuario u : lstUsuarios) {
			System.out.println(u);
		}
		
		//Cierre
		em.close();
	
	}
	

}
