package Paneles;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JMenuBar;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;

public class Principal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel principal;

	private Tabla tabla;
	private AgregarPersona agregarPersona;
	
	private CardLayout layoutPrincipal;
	private JButton botonTabla ;
	private Object[]columnas;
	private DefaultTableModel modelo;
	private JButton botonAgregar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
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
	public Principal() {
		this.setMinimumSize(new Dimension(400,450));
		layoutPrincipal = new CardLayout();
	    getContentPane().setLayout(layoutPrincipal);
		

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 100, 600, 600);
		
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		
		
		botonTabla = new JButton("boton Tabla");
		menuBar.add(botonTabla);
		
		botonAgregar = new JButton("Agregar Persona");
		
		menuBar.add(botonAgregar);
	
		tabla = new Tabla();
		getContentPane().add(tabla, "tabla");
		
		agregarPersona = new AgregarPersona();
		getContentPane().add(agregarPersona, "Agregar Persona");	
		
		

		
		
		
		
		botonTabla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layoutPrincipal.show(getContentPane(), "tabla");
			}
		});
		botonAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				layoutPrincipal.show(getContentPane(), "Agregar Persona");
			}
		});
	
		
		
		
		
		

	}
}
