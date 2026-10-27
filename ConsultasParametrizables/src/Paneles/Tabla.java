package Paneles;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.SpringLayout;
import javax.swing.table.DefaultTableModel;

import DAO.DAO;
import DAO.Persona;

import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Tabla extends JPanel {

    private static final long serialVersionUID = 1L;
    private JTable tabla;
    private Object[] columnas;
    private DefaultTableModel modelo;
    private JScrollPane scrollPane;
   
    public Tabla() 
    {
        setBounds(500, 100, 639, 600);
        SpringLayout springLayout = new SpringLayout();
        setLayout(springLayout);
        
        JLabel label1 = new JLabel("Tabla 1 ");
        springLayout.putConstraint(SpringLayout.NORTH, label1, 49, SpringLayout.NORTH, this);
        springLayout.putConstraint(SpringLayout.WEST, label1, 266, SpringLayout.WEST, this);
        label1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(label1);
        
        tabla = new JTable();
        scrollPane = new JScrollPane(tabla);
        springLayout.putConstraint(SpringLayout.NORTH, scrollPane, 62, SpringLayout.SOUTH, label1);
        springLayout.putConstraint(SpringLayout.WEST, scrollPane, 109, SpringLayout.WEST, this);
        springLayout.putConstraint(SpringLayout.EAST, scrollPane, 506, SpringLayout.WEST, this);
        
        add(scrollPane);

        columnas = new Object[] {"id" ,"nombre", "dni"}; 
                
        modelo = new DefaultTableModel(columnas, 0);

        tabla.setModel(modelo);
        
        JButton botonActualizar = new JButton("Actualizar");
        springLayout.putConstraint(SpringLayout.NORTH, botonActualizar, 459, SpringLayout.NORTH, this);
        springLayout.putConstraint(SpringLayout.SOUTH, scrollPane, -55, SpringLayout.NORTH, botonActualizar);
        springLayout.putConstraint(SpringLayout.WEST, botonActualizar, 226, SpringLayout.WEST, this);
        springLayout.putConstraint(SpringLayout.SOUTH, botonActualizar, -98, SpringLayout.SOUTH, this);
        springLayout.putConstraint(SpringLayout.EAST, botonActualizar, -245, SpringLayout.EAST, this);
        botonActualizar.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(botonActualizar);
        
        botonActualizar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) 
        	{
        		llenarTablas();
        
        	}
        });
        scrollPane.setViewportView(tabla);
        
        
    }
    
    public void llenarTablas()
    {
    	modelo.setRowCount(0);
    	DAO dao = new DAO();
		for(Persona p : dao.consultar())
		{
			modelo.addRow(new Object [] {p.getId(), p.getNombre(),p.getDni()});
		}
    }
}