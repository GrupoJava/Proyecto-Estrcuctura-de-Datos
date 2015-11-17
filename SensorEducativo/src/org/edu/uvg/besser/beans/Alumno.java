package org.edu.uvg.besser.beans;

public class Alumno extends Usuario {
	private String carne;
	private double puntuacion;
	public Alumno() {
		
	}
	
	public Alumno(String nombreUsuario, String password, String nombre,
			String apellido, int idUsuario, String carne, double puntuacion) {
		super(nombreUsuario, password, nombre, apellido, idUsuario);
		this.carne = carne;
		this.puntuacion = puntuacion;
	}

	public String getCarne() {
		return carne;
	}
	public void setCarne(String string) {
		this.carne = string;
	}
	public double getPuntuacion() {
		return puntuacion;
	}
	public void setPuntuacion(double puntuacion) {
		this.puntuacion = puntuacion;
	}
}
