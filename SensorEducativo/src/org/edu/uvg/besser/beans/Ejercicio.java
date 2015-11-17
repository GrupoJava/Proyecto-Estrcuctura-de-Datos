/**
 * Rudy Garrido 14366
 * Jackeline Juarez 14041
 * Leonel Guillen 14451
 * 
 * Proyecto Besser
 * Clase Ejercicio
 */
package org.edu.uvg.besser.beans;

public class Ejercicio {
	private double puntos;
	private String explicacion;
	private int idEjercicio;
	private Respuesta respuesta[];
	
	public Ejercicio() {
		
	}

	public Ejercicio(double puntos, String explicacion, int idEjercicio,
			Respuesta[] respuesta) {
		
		this.puntos = puntos;
		this.explicacion = explicacion;
		this.idEjercicio = idEjercicio;
		this.respuesta = respuesta;
	}

	public double getPuntos() {
		return puntos;
	}

	public void setPuntos(double puntos) {
		this.puntos = puntos;
	}

	public String getExplicacion() {
		return explicacion;
	}

	public void setExplicacion(String explicacion) {
		this.explicacion = explicacion;
	}

	public int getIdEjercicio() {
		return idEjercicio;
	}

	public void setIdEjercicio(int idEjercicio) {
		this.idEjercicio = idEjercicio;
	}

	public Respuesta[] getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(Respuesta[] respuesta) {
		this.respuesta = respuesta;
	}
	
	
	
}
