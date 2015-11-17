/**
 * Rudy Garrido 14366
 * Jackeline Juarez 14041
 * Leonel Guillen 14451
 * 
 * Proyecto Besser
 * Clase MainActivity
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
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.os.Build;

public class MainActivity extends ActionBarActivity {
	
	public final static String EXTRA_MESSAGE = "org.edu.uvg.besser.MESSAGE";
	//metodo principal que mostrara el "login"
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		if (savedInstanceState == null) {
		getSupportFragmentManager().beginTransaction()
				.add(R.id.container, new PlaceholderFragment()).commit();
		}
		/*Spinner tiempo = (Spinner) findViewById(R.id.spinner1);
		String[] tiempos = new String[] { "Hoy", "Una semana", "Dos semanas", "Un mes" };
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, tiempos);
		tiempo.setAdapter(adapter);
		
		tiempo.setOnItemSelectedListener(new OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view,
                    int position, long id) {
            	Controlador.getInstancia().setTiempoSeleccionado(position);
            }
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub
            }
        });*/
		
	}	
	//Controlador que analizara si el usuario ingresado existe
	public void enviarDatos(View view){
			EditText editText = (EditText) findViewById(R.id.edit_message);
			
			//EditText ingresoP = (EditText) findViewById(R.id.editPass);
			TextView error = (TextView) findViewById(R.id.errorContrasena);
			String estudiante = editText.getText().toString();
			//String pass = ingresoP.getText().toString();
			//Controlador.getInstancia().cargarUsuarios();
			int confirmacion = Controlador.getInstancia().buscarEstudiante(Integer.parseInt(estudiante));
			//Se analiza la existencia del usuario y la veracidad de sus credenciales
			if(confirmacion != 0){
				error.setVisibility(View.GONE);
				Controlador.getInstancia().cargarAlarmas();
				Intent intencion = new Intent (this, DesplegarUsuario.class);
				intencion.putExtra("org.edu.uvg.besser.MESSAGE", estudiante);
				startActivity(intencion);
			}else{
				error.setVisibility(View.VISIBLE);
			}
	}

	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			return rootView;
		}
	}

}
