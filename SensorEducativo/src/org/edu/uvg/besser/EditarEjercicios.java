package org.edu.uvg.besser;

import java.util.ArrayList;
import java.util.List;

import org.edu.uvg.besser.beans.Ejercicio;
import org.edu.uvg.besser.controladores.Controlador;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TextView;
import android.os.Build;

public class EditarEjercicios extends ActionBarActivity {
	int ejercicioSeleccionado; 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_editar_ejercicios);

		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
		List<String> listaEjercicios = new ArrayList<String>();
		listaEjercicios.add("Esta ejercitacion no tiene ejercicios. Agregue nuevos");
		if(Controlador.getInstancia().getTemas()[Controlador.getInstancia().getTemaEscogido()].getSubTemas()[Controlador.getInstancia().getsubTemaEscogido()].getEjercicios() != null){
			listaEjercicios.clear();
			for(Ejercicio ejercicio : Controlador.getInstancia().getTemas()[Controlador.getInstancia().getTemaEscogido()].getSubTemas()[Controlador.getInstancia().getsubTemaEscogido()].getEjercicios()){
				listaEjercicios.add(ejercicio.getExplicacion());
			}
		}
		ListView listaEjerciciosVista = (ListView) findViewById(R.id.editarEjercicios);
		listaEjerciciosVista.setOnItemClickListener(new ListenerLista());
		ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this, 
                R.layout.fuentedicion,
                listaEjercicios );
        listaEjerciciosVista.setAdapter(arrayAdapter);
        arrayAdapter.notifyDataSetChanged(); 
	}
	public void eliminar(View view){
		//Controlador.getInstancia().eliminarEjercicio(Controlador.getInstancia().getTemas()[Controlador.getInstancia().getTemaEscogido()].getSubTemas()[Controlador.getInstancia().getsubTemaEscogido()].getEjercicios()[ejercicioSeleccionado].getIdEjercicio());
		List<String> listaEjercicios = new ArrayList<String>();
		//Controlador.getInstancia().cargarEjercicio();
		for(Ejercicio ejercicio : Controlador.getInstancia().getTemas()[Controlador.getInstancia().getTemaEscogido()].getSubTemas()[Controlador.getInstancia().getsubTemaEscogido()].getEjercicios()){
			listaEjercicios.add(ejercicio.getExplicacion());
		}
		ListView listaEjerciciosVista = (ListView) findViewById(R.id.editarEjercicios);
		listaEjerciciosVista.setOnItemClickListener(new ListenerLista());
		ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this, 
                R.layout.fuentedicion,
                listaEjercicios );
        listaEjerciciosVista.setAdapter(arrayAdapter);
        arrayAdapter.notifyDataSetChanged(); 
	}
	public void agregar(View view){
		//TextView instruccionT = (TextView) findViewById(R.id.instruccion);
		String instruccion = ((TextView) findViewById(R.id.instruccion)).getText().toString();
		String respuesta1 = ((TextView) findViewById(R.id.respuesta1)).getText().toString();
		String respuesta2 = ((TextView) findViewById(R.id.respuesta2)).getText().toString();
		String respuesta3 = ((TextView) findViewById(R.id.respuesta3)).getText().toString();
		String respuesta4 = ((TextView) findViewById(R.id.respuesta4)).getText().toString();
		double puntuacion = Double.parseDouble(((TextView) findViewById(R.id.puntuacion)).getText().toString());
		int validez1 = 0;
		int validez2 = 0;
		int validez3 = 0;
		int validez4 = 0;
		if(((CheckBox) findViewById(R.id.validez1)).isChecked()){
			validez1=1;
		}
		if(((CheckBox) findViewById(R.id.validez2)).isChecked()){
			validez2=1;
		}
		if(((CheckBox) findViewById(R.id.validez3)).isChecked()){
			validez3=1;
		}
		if(((CheckBox) findViewById(R.id.validez4)).isChecked()){
			validez4=1;
		}
		//Controlador.getInstancia().agregarEjercicioEjercicio(instruccion, respuesta1, validez1, respuesta2, validez2, respuesta3, validez3, respuesta4, validez4, puntuacion);
		List<String> listaEjercicios = new ArrayList<String>();
		//Controlador.getInstancia().cargarEjercicio();
		for(Ejercicio ejercicio : Controlador.getInstancia().getTemas()[Controlador.getInstancia().getTemaEscogido()].getSubTemas()[Controlador.getInstancia().getsubTemaEscogido()].getEjercicios()){
			listaEjercicios.add(ejercicio.getExplicacion());
		}
		ListView listaEjerciciosVista = (ListView) findViewById(R.id.editarEjercicios);
		listaEjerciciosVista.setOnItemClickListener(new ListenerLista());
		ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this, 
                R.layout.fuentedicion,
                listaEjercicios );
        listaEjerciciosVista.setAdapter(arrayAdapter);
        arrayAdapter.notifyDataSetChanged(); 
	}
	private class ListenerLista implements OnItemClickListener{
		public void onItemClick(AdapterView<?> adapterView, View view,int position, long id) { 
			for (int j = 0; j < adapterView.getChildCount(); j++)
                adapterView.getChildAt(j).setBackgroundColor(Color.TRANSPARENT);
            view.setBackgroundColor(Color.LTGRAY);
            ejercicioSeleccionado = position;
        }
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.editar_ejercicios, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(
					R.layout.fragment_editar_ejercicios, container, false);
			return rootView;
		}
	}

}
