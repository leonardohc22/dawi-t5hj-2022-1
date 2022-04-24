package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demo04 {

	public static void main(String[] args) {
		// obtener un objeto Usuario seg�n el c�digo o id
		
		// fabrica de acceso de datos --> DAO
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		EntityManager em = fabrica.createEntityManager();

		// .....acciones
		Usuario u = em.find(Usuario.class, 55); // si existe el ID  -> devuelve el objeto
												// si no existe --> null
		if(u != null)
			System.out.println(u);
		else
			System.err.println("C�digo no existe!!!");

		em.close();
	}
}
