package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demo05 {

	public static void main(String[] args) {
		//Version mejorada de Eliminar

		//encontrar y devolver los datos de un usuario, segun su codigo.
		
		//Fabrica --> DAO
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");	
		//Manejar Entidades
		EntityManager em = fabrica.createEntityManager();	
				
		//empieza la busqueda ---- em.getTransaction().begin();
				
	
		//Select-----where id 
		Usuario u = em.find(Usuario.class, 10);
		//Devuelve un objeto de usuario si encuentra el Id, y si no devuelve null
		if (u == null) 
			System.err.print("Usuario No Existe !!!!");
		else 
			em.getTransaction().begin();
			em.remove(em.find(Usuario.class, u.getCodigo()));
		    em.getTransaction().commit();
		
			System.out.print("Eliminado");
		
		
			
		
		//Cierre
		em.close();
	
		
	}
}
