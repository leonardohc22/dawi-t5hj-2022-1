package app;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

//import model.Categoria;
import model.Producto;
import model.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;

public class FrmLogin extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsuario;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmLogin frame = new FrmLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 146);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnIngresar = new JButton("Ingresar");
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ingresar();
			}
		});
		btnIngresar.setBounds(324, 29, 89, 23);
		contentPane.add(btnIngresar);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(122, 30, 161, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Usuario :");
		lblNewLabel.setBounds(10, 33, 102, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblClave = new JLabel("Clave :");
		lblClave.setBounds(10, 64, 102, 14);
		contentPane.add(lblClave);
		
		txtClave = new JTextField();
		txtClave.setColumns(10);
		txtClave.setBounds(122, 61, 161, 20);
		contentPane.add(txtClave);
		
	}

	
	private JTextField txtClave;
	
	
	void ingresar() {
		String usuario, clave;

		usuario = txtUsuario.getText(); // JOptionPane.showInputDialog("Ingrese usuario: ");
		clave = txtClave.getText(); // JOptionPane.showInputDialog("Ingrese clave: ");

		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		EntityManager em = fabrica.createEntityManager();

		Query query = em.createNativeQuery("{call usp_validaAcceso (?, ?)}", Usuario.class);
		query.setParameter(1, usuario);
		query.setParameter(2, clave);
	/**	Usuario u = (Usuario) query.getSingleResult();
		if (u == null) {
			System.out.println("Usuario no existe");
		} else {
			System.out.println("Bienvenido " + u.getNombre());
			System.out.println("Tus datos son: " + u);
		}
		System.out.println("--------------------------------------------");*/
		try {
			Usuario u = (Usuario) query.getSingleResult();
			System.out.println("Bienvenido " + u.getNombre());
			System.out.println("Tus datos son: " + u);
		} catch (Exception e) {
			System.out.println("Usuario no existe");
		}
	}
}
