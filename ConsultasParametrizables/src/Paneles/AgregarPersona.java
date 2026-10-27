package Paneles;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SpringLayout;

import DAO.DAO;
import DAO.Persona;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AgregarPersona extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField ingresarNombre;
	private JTextField ingresarDni;


	/**
	 * Create the panel.
	 */
	public AgregarPersona() {

		setBounds(500, 100, 639, 600);
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);
		
		JLabel lblNewLabel = new JLabel("Tabla 2");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel, 5, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel, 296, SpringLayout.WEST, this);
		add(lblNewLabel);
		
		ingresarNombre = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, ingresarNombre, 54, SpringLayout.SOUTH, lblNewLabel);
		springLayout.putConstraint(SpringLayout.WEST, ingresarNombre, 236, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, ingresarNombre, 98, SpringLayout.SOUTH, lblNewLabel);
		springLayout.putConstraint(SpringLayout.EAST, ingresarNombre, -202, SpringLayout.EAST, this);
		ingresarNombre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(ingresarNombre);
		ingresarNombre.setColumns(10);
		
		ingresarDni = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, ingresarDni, 56, SpringLayout.SOUTH, ingresarNombre);
		springLayout.putConstraint(SpringLayout.WEST, ingresarDni, 0, SpringLayout.WEST, ingresarNombre);
		springLayout.putConstraint(SpringLayout.SOUTH, ingresarDni, 107, SpringLayout.SOUTH, ingresarNombre);
		springLayout.putConstraint(SpringLayout.EAST, ingresarDni, 0, SpringLayout.EAST, ingresarNombre);
		add(ingresarDni);
		ingresarDni.setColumns(10);
		
		JButton btnNewButton = new JButton("Agregar Persona");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				Persona p1 = capturarDatos();
				DAO dao = new DAO();
				dao.agregarPersonaPorParametro(p1);
				System.out.println("Se agrego");
			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, btnNewButton, 77, SpringLayout.SOUTH, ingresarDni);
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton, 251, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, btnNewButton, 150, SpringLayout.SOUTH, ingresarDni);
		springLayout.putConstraint(SpringLayout.EAST, btnNewButton, 0, SpringLayout.EAST, ingresarNombre);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		add(btnNewButton);
		
	}
	
	public Persona capturarDatos()
	{
		String nombre = ingresarNombre.getText();
		String dni = ingresarDni.getText();
		Persona p= new Persona(nombre, dni);
		return p;
	}
}
