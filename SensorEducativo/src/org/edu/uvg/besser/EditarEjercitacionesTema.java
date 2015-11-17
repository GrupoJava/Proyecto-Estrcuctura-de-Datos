package org.edu.uvg.besser;

import java.util.ArrayList;
import java.util.List;

import org.edu.uvg.besser.beans.Ejercicio;
import org.edu.uvg.besser.beans.Tema;
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
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
import android.os.Build;

public class EditarEjercitacionesTema extends ActionBarActivity {

	private Intent intencionSalida;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_editar_ejercitaciones_tema);

		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
		//Controlador.getInstancia().cargarTemas();
		List<String> listaTemasNombres = new ArrayList<String>();
		listaTemasNombres.add("No hay temas");
		if(Controlador.getInstancia().getTemas() != null){
			listaTemasNombres.clear();
			for(Tema tema :Controlador.getInstancia().getTemas()){
				listaTemasNombres.add(tema.getTema());
			} 
		}
		ListView listaTemas = (ListView) findViewById(R.id.temasEjercitacion);
		ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this, 
                android.R.layout.simple_list_item_1,
                listaTemasNombres );
		listaTemas.setAdapter(arrayAdapter);
		listaTemas.setOnItemClickListener(new ListenerLista());
        arrayAdapter.notifyDataSetChanged(); 
        intencionSalida= new Intent(this, EditarEjercitacion.class);
	}
	private class ListenerLista implements OnItemClickListener{
		public void onItemClick(AdapterView<?> parent, View view,
                int position, long id) { 
			Controlador.getInstancia().setTemaEscogido(position);
			Controlador.getInstancia().setTemaEscogido(position);
			startActivity(intencionSalida);
        }
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.editar_ejercitaciones_tema, menu);
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
					R.layout.fragment_editar_ejercitaciones_tema, container,
					false);
			return rootView;
		}
	}

}
