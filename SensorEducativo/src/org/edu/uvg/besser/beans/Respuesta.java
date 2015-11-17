/**
 * Rudy Garrido 14366
 * Jackeline Juarez 14041
 * Leonel Guillen 14451
 * 
 * Proyecto Besser
 * Clase Ejercicio
 */
package org.edu.uvg.besser.beans;

public class Respuesta {
	private String respuesta;
	private int validez; //0 falso 1 cierto
	private int idRespuesta;
	
	public Respuesta() {
	}

	public Respuesta(String respuesta, int validez, int idRespuesta) {
		this.respuesta = respuesta;
		this.validez = validez;
		this.idRespuesta = idRespuesta;
	}

	public String getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}

	public int getValidez() {
		return validez;
	}

	public void setValidez(int validez) {
		this.validez = validez;
	}

	public int getIdRespuesta() {
		return idRespuesta;
	}

	public void setIdRespuesta(int idRespuesta) {
		this.idRespuesta = idRespuesta;
	}
	
}
