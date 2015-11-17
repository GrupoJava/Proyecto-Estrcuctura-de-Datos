/**
 * Rudy Garrido 14366
 * Jackeline Juarez 14041
 * Leonel Guillen 14451
 * 
 * Proyecto Besser
 * Clase ActivityResultado
 */
package org.edu.uvg.besser;

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
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.os.Build;

public class ActivityResultado extends ActionBarActivity {
	//Creacion de la ventana que le mostrara al usuario su puntuacion
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		//Inician los textos de aclaracion
		TextView primeraAclaracion = new TextView(this); 
		primeraAclaracion.setText("Ha finalizado el ejercicio!");
		primeraAclaracion.setTextSize(18);
		primeraAclaracion.setPadding(60, 120, 80, 20);
		TextView segundaAclaracion = new TextView(this); 
		segundaAclaracion.setPadding(60, 20, 80, 20);
		segundaAclaracion.setText("Podra realizar de nuevo el ejercicio pero sin puntuacion a su record");
		TextView terceraAclaracion = new TextView(this); 
		terceraAclaracion.setPadding(60, 20, 80, 20);
		terceraAclaracion.setText("Su puntuacion final fue:");
		TextView cuataAclaracion = new TextView(this);
		Intent intencion = getIntent();
		//Peticion al controlador la puntuacion del ejercicio
		double puntos =  Double.parseDouble(intencion.getStringExtra(MostrarEjercicios.EXTRA_MESSAGE));
		cuataAclaracion.setText(puntos+" puntos");
		cuataAclaracion.setPadding(60, 20, 80, 20);
		//Se agregan todos los componenetes al contenedor principal
		LinearLayout layout = new LinearLayout(this);
		layout.setOrientation(1);
		layout.addView(primeraAclaracion);
		layout.addView(segundaAclaracion);
		layout.addView(terceraAclaracion);
		layout.addView(cuataAclaracion);
		setContentView(layout);
	}

	

}
