package org.edu.uvg.besser.beans;

public class Profesor extends Usuario {
	private int idProfesor;
	private int permiso;
	public Profesor() {
		
	}
	public Profesor(String nombreUsuario, String password, String nombre,
			String apellido, int idUsuario, int idProfesor, int permiso) {
		super(nombreUsuario, password, nombre, apellido, idUsuario);
		this.idProfesor = idProfesor;
		this.permiso = permiso;
	}

	public int getIdProfesor() {
		return idProfesor;
	}
	public void setIdProfesor(int idProfesor) {
		this.idProfesor = idProfesor;
	}
	public int getPermiso() {
		return permiso;
	}
	public void setPermiso(int permiso) {
		this.permiso = permiso;
	}
	
	
}
