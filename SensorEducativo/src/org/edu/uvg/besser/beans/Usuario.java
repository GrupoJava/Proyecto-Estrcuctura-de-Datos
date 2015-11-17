/**
 * Rudy Garrido 14366
 * Jackeline Juarez 14041
 * Leonel Guillen 14451
 * 
 * Proyecto Besser
 * Clase Usuario
 */
package org.edu.uvg.besser.beans;

public class Usuario {
	private String nombreUsuario;
	private String password;
	private String nombre;
	private String apellido;
	private int idUsuario;
	public Usuario() {
	}
	
	public Usuario(String nombreUsuario, String password, String nombre,
			String apellido, int idUsuario) {
		super();
		this.nombreUsuario = nombreUsuario;
		this.password = password;
		this.nombre = nombre;
		this.apellido = apellido;
		this.idUsuario = idUsuario;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	
	
}
