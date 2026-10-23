package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DAO {

	private String user = "root";
	private String psw = "admin";
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
	

	
	public void eliminar(int dni)
	{
		String sql = "DELETE FROM `tabla`WHERE dni = ?;";
		Connection conexion = null;
		try {
			conexion = conectar();
			PreparedStatement stnt = conexion.prepareStatement(sql);
			stnt.setInt(1,dni);
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
	
	public void  actualizar(Persona p, String nombree, int dniNuevo)
	{
		Persona p1 = p;
		String sql = "UPDATE tabla SET nombre = ? , dni = ? WHERE dni = ?;";
		Connection conexion = null;
		try {
			conexion = conectar();
			PreparedStatement stnt = conexion.prepareStatement(sql);
			stnt.setString(1, nombree);
			stnt.setInt(2, dniNuevo);
			stnt.setInt(3, p.getDni());
			
			
			filas = stnt.executeUpdate(sql);
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
	
	public ArrayList<String> consultar(Persona p)
	{
		String sql = "SELECT nombre FROM tabla WHERE dni = 12345678";
		Connection conexion = null;
		ArrayList<String> solucion = new ArrayList<>();
		try {
			conexion = conectar();
			Statement stnt = conexion.createStatement();
		    ResultSet rs = stnt.executeQuery(sql);	
			while(rs.next())
			{
				String nombre = rs.getString("nombre");
				solucion.add(nombre);
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
	
	
	public int agregarPersonaPorParametro(Persona p) {
		Connection conexion = null;
		
		String sql = "INSERT INTO `persona`(nombre, dni)VALUES(?,?);";
		try {
			conexion = conectar();
			PreparedStatement stmt = conexion.prepareStatement(sql);
			stmt.setString(1, p.getNombre());
			stmt.setInt(2, p.getDni());
		
			filas = stmt.executeUpdate(); 
			System.out.println(filas);
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			try {
				conexion.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return filas;
	}
	
	

}