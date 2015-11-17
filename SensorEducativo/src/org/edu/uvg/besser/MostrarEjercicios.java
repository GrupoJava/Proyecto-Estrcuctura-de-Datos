/**
 * Rudy Garrido 14366
 * Jackeline Juarez 14041
 * Leonel Guillen 14451
 * 
 * Proyecto Besser
 * Clase MostrarEjercicios
 */
package org.edu.uvg.besser;

import org.edu.uvg.besser.beans.Ejercicio;
import org.edu.uvg.besser.beans.Respuesta;
import org.edu.uvg.besser.beans.SubTema;
import org.edu.uvg.besser.controladores.Controlador;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.os.Build;

public class MostrarEjercicios extends ActionBarActivity implements OnClickListener{
	private int numeroRespuesta = 0;
	private int respuestaCorrecta = 0;
	private double puntuacion=0;
	public final static String EXTRA_MESSAGE = "org.edu.uvg.besser.MESSAGE";
	//Metodo de iniciacion de la ventana, se mostrara el primer ejercicio de la serie
	protected void onCreate(Bundle savedInstanceState) {
		//Controlador.getInstancia().cargarEjercicio();
		puntuacion = 0;
		super.onCreate(savedInstanceState);
		Intent intencionEntrante = getIntent();
		int subTemaId = Integer.parseInt(intencionEntrante.getStringExtra(MostrarTema.EXTRA_MESSAGE));
		int temaEscogido = Controlador.getInstancia().getTemaEscogido();
		SubTema subTema = Controlador.getInstancia().getTemas()[temaEscogido].getSubTemas()[subTemaId];
		Ejercicio[] ejercicios = subTema.getEjercicios();
		Respuesta[] respuestasArr = ejercicios[numeroRespuesta].getRespuesta();
		LinearLayout principal = new LinearLayout(this);
		principal.setOrientation(1);
		TextView titulo = new TextView(this);
		titulo.setText(subTema.getSubTema());
		titulo.setPadding(80, 40, 80, 40);
		TextView explicacion = new TextView(this);
		explicacion.setText(subTema.getExplicacion());
		explicacion.setPadding(60, 20, 80, 20);
		TextView numeroEjercicio = new TextView(this);
		numeroEjercicio.setText("Ejercicio"+(numeroRespuesta+1));
		numeroEjercicio.setPadding(60, 20, 80, 20);
		numeroEjercicio.setId(4);
		TextView ejercicio = new TextView(this);
		ejercicio.setText(ejercicios[numeroRespuesta].getExplicacion());
		ejercicio.setPadding(60, 20, 80, 20);
		ejercicio.setId(5);
		Button enviar = new Button(this);
		enviar.setText("Responder");
		enviar.setOnClickListener(this);
		enviar.setPadding(40, 20, 40, 20);
		TextView correccion = new TextView(this);
		correccion.setVisibility(View.INVISIBLE);
		correccion.setId(6);
		LinearLayout respuestas = new LinearLayout(this);
		respuestas.setPadding(80, 40, 80, 40);
		//Se agregan los componentes prinicpales con los contenedores
		principal.addView(titulo);
		principal.addView(explicacion);
		principal.addView(numeroEjercicio);
		principal.addView(ejercicio);
		principal.addView(respuestas);
		principal.addView(enviar);
		principal.addView(correccion);
		//Se agregan las posibles respuestas en dos contenedores de manera cuadriculada
		LinearLayout primerasRespuestas = new LinearLayout(this);
		primerasRespuestas.setOrientation(1);
		CheckBox primeraRespuesta = new CheckBox(this);
		primeraRespuesta.setText(respuestasArr[0].getRespuesta());
		primeraRespuesta.setId(0);
		CheckBox segundaRespuesta = new CheckBox(this);
		segundaRespuesta.setText(respuestasArr[1].getRespuesta());
		segundaRespuesta.setId(1);
		primerasRespuestas.addView(primeraRespuesta);
		primerasRespuestas.addView(segundaRespuesta);
		
		LinearLayout segundasRespuestas = new LinearLayout(this);
		segundasRespuestas.setOrientation(1);
		CheckBox terceraRespuesta = new CheckBox(this);
		terceraRespuesta.setText(respuestasArr[2].getRespuesta());
		terceraRespuesta.setId(2);
		CheckBox cuartaRespuesta = new CheckBox(this);
		cuartaRespuesta.setText(respuestasArr[3].getRespuesta());
		cuartaRespuesta.setId(3);
		
		segundasRespuestas.addView(terceraRespuesta);
		segundasRespuestas.addView(cuartaRespuesta);
	
		respuestas.addView(primerasRespuestas);
		respuestas.addView(segundasRespuestas);
		setContentView(principal);
	}
	//Metodo cuando se envia una respuesta, se cambia el ejercicio por el siguiente en lista
	//y se muestra si la respuesta fue correcta
	public void onClick(View view) {
		System.out.println("Numero de respuesta"+numeroRespuesta);
		if(numeroRespuesta < Controlador.getInstancia().getTemas()[Controlador.getInstancia().getTemaEscogido()].getSubTemas().length){
			Intent intencionEntrante = getIntent();
			int subTemaId = Integer.parseInt(intencionEntrante.getStringExtra(MostrarTema.EXTRA_MESSAGE));
			int temaEscogido = Controlador.getInstancia().getTemaEscogido();
			SubTema subTema = Controlador.getInstancia().getTemas()[temaEscogido].getSubTemas()[subTemaId];
			Ejercicio[] ejercicios = subTema.getEjercicios();
			Respuesta[] respuestasArr = ejercicios[numeroRespuesta].getRespuesta();
			TextView correccion = (TextView) findViewById(6);
			correccion.setVisibility(View.VISIBLE);
			for(int numero = 0; numero<4; numero++){
				CheckBox respuestaPrevia = (CheckBox) findViewById(numero);
				if(respuestaPrevia.isChecked()){
					if(respuestasArr[numero].getValidez() == 1){
						correccion.setText("Correcto!");
						puntuacion = puntuacion + ejercicios[numeroRespuesta].getPuntos();
					}else{
						correccion.setText("Incorrecto");
					}
				}
			}
			/*int[] posibles = {0,1,2,3};
			boolean bandera = false; 
			//Se analiza la validez de la respuesta
			for(int numero:posibles){
				CheckBox respuestaPrevia = (CheckBox) findViewById(numero);
				if(respuestaPrevia.isChecked()){
					if(numero == respuestaCorrecta){
						bandera =true;
					}else{
						bandera = false;
						break;
					}
				}
			}
			//Se cambia el texto de acorde a la validez de la respeusta
			if(bandera){
				correccion.setText("Correcto!");
				puntuacion = puntuacion + ejercicios[numeroRespuesta].getPuntos(); 
			}else{
				correccion.setText("Incorrecto");
			}*/
			if((numeroRespuesta+1)<Controlador.getInstancia().getTemas()[Controlador.getInstancia().getTemaEscogido()].getSubTemas().length){
				numeroRespuesta++;
				//Se cambia el ejericio y las opciones para el siguiente ejercicios
				respuestasArr = ejercicios[numeroRespuesta].getRespuesta();
				TextView numeroEjercicio = (TextView) findViewById(4);
				numeroEjercicio.setText("Ejercicio"+(numeroRespuesta+1));
				TextView ejercicio = (TextView) findViewById(5);
				ejercicio.setText(ejercicios[numeroRespuesta].getExplicacion());
				System.out.println(respuestaCorrecta);
				CheckBox primeraRespuesta= (CheckBox) findViewById(0);
				primeraRespuesta.setText(respuestasArr[0].getRespuesta().toString());
				primeraRespuesta.setChecked(false);
				CheckBox segundaRespuesta = (CheckBox) findViewById(1);
				segundaRespuesta.setText(respuestasArr[1].getRespuesta().toString());
				segundaRespuesta.setChecked(false);
				CheckBox teceraRespuesta = (CheckBox) findViewById(2);
				teceraRespuesta.setText(respuestasArr[2].getRespuesta().toString());
				teceraRespuesta.setChecked(false);
				CheckBox cuartaRespuesta = (CheckBox) findViewById(3);
				System.out.println(respuestasArr[3].getIdRespuesta());
				cuartaRespuesta.setText(respuestasArr[3].getRespuesta().toString());
				cuartaRespuesta.setChecked(false);
			}else{
				//Controlador.getInstancia().agregarRegistro(puntuacion);
				Intent intencion = new Intent(this, ActivityResultado.class);
				intencion.putExtra("org.edu.uvg.besser.MESSAGE", String.valueOf(puntuacion));
				startActivity(intencion);
			}
		}else{
			//Controlador.getInstancia().agregarRegistro(puntuacion);
			Intent intencion = new Intent(this, ActivityResultado.class);
			intencion.putExtra("org.edu.uvg.besser.MESSAGE", String.valueOf(puntuacion));
			startActivity(intencion);
		}
	}
	
	

}
