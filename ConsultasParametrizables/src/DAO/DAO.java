package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DAO {

	private String user = "root";
	private String psw = "123456";
	private String path = "jdbc:mysql://localhost:3306/bd_53";

	int filas;

	public Connection conectar() {
		Connection conexion = null;
		try {
			conexion = DriverManager.getConnection(path, user, psw);

			System.out.println("se conecto");
		} catch (SQLException e) {
			e.printStackTrace();

		}

		return conexion;
	}

	public void agregar() {
		String sql = "INSERT INTO `tabla`(`nombre`,`dni`)VALUES('Lautaro',12345678) , ('Yamile',48856758) ;";
		Connection conexion = null;
		try {
			conexion = conectar();
			Statement stnt = conexion.createStatement();
			stnt.executeUpdate(sql);
			System.out.println("se agrego");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conexion.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

	}
	

	
	public void eliminar(String dni)
	{
		String sql = "DELETE FROM `tabla`WHERE dni = ?;";
		Connection conexion = null;
		try {
			conexion = conectar();
			PreparedStatement stnt = conexion.prepareStatement(sql);
			stnt.setString(1,dni);
			stnt.executeUpdate(sql);
			System.out.println("se elimino");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conexion.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	}
	
	public void  actualizar(Persona p, String nombree, String dniNuevo)
	{
		Persona p1 = p;
		String sql = "UPDATE tabla SET nombre = ? , dni = ? WHERE dni = ?;";
		Connection conexion = null;
		try {
			conexion = conectar();
			PreparedStatement stnt = conexion.prepareStatement(sql);
			stnt.setString(1, nombree);
			stnt.setString(2, dniNuevo);
			stnt.setString(3, p.getDni());
			
			
		
			System.out.println("se actualizo");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conexion.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	}
	
	public ArrayList<Persona> consultar()
	{
		String sql = "SELECT * FROM tabla ";
		Connection conexion = null;
		ArrayList<Persona> solucion = new ArrayList<>();
		try {
			conexion = conectar();
			Statement stnt = conexion.createStatement();
		    ResultSet rs = stnt.executeQuery(sql);	
			while(rs.next())
			{
				
				String nombre = rs.getString("nombre");
				String dni = rs.getString("dni");
				Persona p1 = new Persona (nombre, dni);
				solucion.add(p1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conexion.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return solucion;
	}
	
	
	public void agregarPersonaPorParametro(Persona p) {
		Connection conexion = null;
		
		String sql = "INSERT INTO persona (nombre, dni)VALUES(?,?);";
		try {
			conexion = conectar();
			PreparedStatement stmt = conexion.prepareStatement(sql);
			stmt.setString(1, p.getNombre());
			stmt.setString(2, p.getDni());
		
		 
			System.out.println("se agrego");
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			try {
				conexion.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	

}