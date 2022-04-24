package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.swing.JOptionPane;

import model.Usuario;

public class Login {
	public static void main(String[] args) {
		String usuario, clave;
		
		usuario = "U001@gmail.com"; //JOptionPane.showInputDialog("Ingrese usuario: ");
		clave = "10001"; //JOptionPane.showInputDialog("Ingrese clave: ");
		
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		EntityManager em = fabrica.createEntityManager();

		Query query = em.createNativeQuery("{call usp_validaAcceso (?, ?)}", Usuario.class);
		query.setParameter(1, "U001@gmail.com");
		query.setParameter(2, "10001");
		Usuario u = (Usuario) query.getSingleResult();
		if (u == null) {
			System.out.println("Usuario no existe");
		} else {
			System.out.println("Bienvenido " + u.getNombre());
			System.out.println("Tus datos son: " + u);
		}
		System.out.println("--------------------------------------------");
	}
}
