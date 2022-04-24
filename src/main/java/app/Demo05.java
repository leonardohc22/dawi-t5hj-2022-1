package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demo05 {
	
	public static void main(String[] args) {
		// eliminar --> usando búsqueda
		
		// fabrica de acceso de datos --> DAO
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		EntityManager em = fabrica.createEntityManager();
		
		// .....acciones
		Usuario u = em.find(Usuario.class, 55); // si existe el ID -> devuelve el objeto
												// si no existe --> null
		if (u != null) {
			em.getTransaction().begin();
			em.remove(u); 
			em.getTransaction().commit();
			System.out.println("Usuario eliminado");
		}else {
			System.err.println("Código no existe!!!");
		}
		
		em.close();
	}
}
