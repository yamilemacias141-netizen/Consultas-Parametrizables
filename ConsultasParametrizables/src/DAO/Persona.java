package DAO;

public class Persona
{
	private int id = 1;
	private String nombre;
	private String dni;
	
	public Persona (String nombre, String dni)
	{
		this.id=id;
		this.nombre=nombre;
		this.dni = dni;
		id++;
	}

	public String getNombre() {
		return nombre;
	}


	public String getDni() {
		return dni;
	}
	
	public int getId()
	{
		return id;
	}

	

}
