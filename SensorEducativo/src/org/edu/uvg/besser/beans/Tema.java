/**
 * Rudy Garrido 14366
 * Jackeline Juarez 14041
 * Leonel Guillen 14451
 * 
 * Proyecto Besser
 * Clase Tema
 */
package org.edu.uvg.besser.beans;

public class Tema {
	private String tema;
	private SubTema[] subTemas;
	private String explicacion;
	private int idTema;
	public Tema(String tema, SubTema[] subTemas, String explicacion, int idTema) {
		
		this.tema = tema;
		this.subTemas = subTemas;
		this.explicacion = explicacion;
		this.idTema = idTema;
	}
	public Tema() {
		
	}
	public String getTema() {
		return tema;
	}
	public void setTema(String tema) {
		this.tema = tema;
	}
	public SubTema[] getSubTemas() {
		return subTemas;
	}
	public void setSubTemas(SubTema[] subTemas) {
		this.subTemas = subTemas;
	}
	public String getExplicacion() {
		return explicacion;
	}
	public void setExplicacion(String explicacion) {
		this.explicacion = explicacion;
	}
	public int getIdTema() {
		return idTema;
	}
	public void setIdTema(int idTema) {
		this.idTema = idTema;
	}
	
	
}
