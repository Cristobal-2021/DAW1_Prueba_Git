package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demo02 {

	public static void main(String[] args) {
		
		
		// Actualizar un nuevo usuario
		Usuario u = new Usuario();
		u.setCodigo(3);
		u.setNombre("Mikasa");
		u.setApellido("Ackerman");
		u.setUsuario("erenforever@mail.com");
		u.setClave("Eren");
		u.setFchnacim("2001/04/04");
		u.setTipo(2);
		u.setEstado(2);
		
		// proceso de registro
		
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");		
		EntityManager em = fabrica.createEntityManager();	
		em.getTransaction().begin();
		
		em.merge(u);// ??? ---> Actualizar
		
		
		em.getTransaction().commit();
		em.close();
		System.out.print("terminó.....");
		

	}

}