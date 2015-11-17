/**
 * Rudy Garrido 14366
 * Jackeline Juarez 14041
 * Leonel Guillen 14451
 * 
 * Proyecto Besser
 * Clase SubTema
 */
package org.edu.uvg.besser.beans;

public class SubTema {
	private String subTema;
	private String explicacion;
	private Ejercicio[] ejercicios;
	private int idEjercitacion;
	public SubTema(String subTema, String explicacion, Ejercicio[] ejercicios,
			int idEjercitacion) {
		
		this.subTema = subTema;
		this.explicacion = explicacion;
		this.ejercicios = ejercicios;
		this.idEjercitacion = idEjercitacion;
	}
	public SubTema() {
	
	}
	public String getSubTema() {
		return subTema;
	}
	public void setSubTema(String subTema) {
		this.subTema = subTema;
	}
	public String getExplicacion() {
		return explicacion;
	}
	public void setExplicacion(String explicacion) {
		this.explicacion = explicacion;
	}
	public Ejercicio[] getEjercicios() {
		return ejercicios;
	}
	public void setEjercicios(Ejercicio[] ejercicios) {
		this.ejercicios = ejercicios;
	}
	public int getIdEjercitacion() {
		return idEjercitacion;
	}
	public void setIdEjercitacion(int idEjercitacion) {
		this.idEjercitacion = idEjercitacion;
	}
	
}
