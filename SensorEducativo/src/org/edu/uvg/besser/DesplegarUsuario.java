/**
 * Rudy Garrido 14366
 * Jackeline Juarez 14041
 * Leonel Guillen 14451
 * 
 * Proyecto Besser
 * Clase DesplegarUsuario
 */
package org.edu.uvg.besser;

import org.edu.uvg.besser.controladores.Controlador;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.os.Build;

public class DesplegarUsuario extends ActionBarActivity {
	//Metodo para la creacion de la ventnaa
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_desplegar_usuario);
		TextView resaltar=null;
		switch(Controlador.getInstancia().getDiaProblematico()){
			case 1:
				resaltar = (TextView) findViewById(R.id.textViewDia1);
				break;
			case 2:
				resaltar = (TextView) findViewById(R.id.textView4);
				break;
			case 3:
				resaltar = (TextView) findViewById(R.id.textView5);
				break;
			case 4:
				resaltar = (TextView) findViewById(R.id.textView6);
				break;
			case 5:
				resaltar = (TextView) findViewById(R.id.textView7);
				break;
			case 6:
				resaltar = (TextView) findViewById(R.id.textView8);
				break;
			case 7:
				resaltar = (TextView) findViewById(R.id.textView9);
				break;
		}
		resaltar.setTextColor(Color.RED);
		resaltar.setTextSize(20);
		int hora = Controlador.getInstancia().getHoraProblematica();
		if(hora>=12){
			resaltar = (TextView) findViewById(R.id.textView11);
			if(hora!=12)
				hora=hora-12;
		}else{
			resaltar = (TextView) findViewById(R.id.textView10);
			if(hora==0){
				hora=12;
			}
		}
		resaltar.setTextColor(Color.RED);
		resaltar.setTextSize(20);
		switch(hora){
			case 1:
				resaltar = (TextView) findViewById(R.id.textView12);
				break;
			case 2:
				resaltar = (TextView) findViewById(R.id.textView14);
				break;
			case 3:
				resaltar = (TextView) findViewById(R.id.textView13);
				break;
			case 4:
				resaltar = (TextView) findViewById(R.id.textView15);
				break;
			case 5:
				resaltar = (TextView) findViewById(R.id.textView16);
				break;
			case 6:
				resaltar = (TextView) findViewById(R.id.textView17);
				break;
			case 7:
				resaltar = (TextView) findViewById(R.id.TextView01);
				break;
			case 8:
				resaltar = (TextView) findViewById(R.id.TextView02);
				break;
			case 9:
				resaltar = (TextView) findViewById(R.id.TextView03);
				break;
			case 10:
				resaltar = (TextView) findViewById(R.id.TextView04);
				break;
			case 11:
				resaltar = (TextView) findViewById(R.id.TextView06);
				break;
			case 12:
				resaltar = (TextView) findViewById(R.id.TextView05);
				break;
		}
		resaltar.setTextColor(Color.RED);
		resaltar.setTextSize(20);
		
		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
		
	}
	//Metodo que se activara al presionar el boton que llamara a la siguiente ventata
	public void enviarDatos(View view){
		Intent intencion = new Intent (this, DisplayMessageActivity.class);
		startActivity(intencion);
	}
	//Metodo que señalara el archivo que contiene la vista de la ventana
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(
					R.layout.fragment_desplegar_usuario, container, false);
			return rootView;
		}
	}

}
